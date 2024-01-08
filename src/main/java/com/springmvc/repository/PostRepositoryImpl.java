package com.springmvc.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;
import com.springmvc.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


import com.springmvc.util.CloudStorageUtil;


@Repository
public class PostRepositoryImpl implements PostRepository {
	private JdbcTemplate template;
	
//    private String filePath ="C:\\Users\\hanhu\\spring-project\\spring-project\\src\\main\\webapp\\resources\\images\\";
    //private String filePath ="/var/lib/tomcat9/webapps/miniboard/resources/images/";
    private static final String CATALINA_HOME = System.getenv("CATALINA_HOME");
    private String filePath = CATALINA_HOME + File.separator + "webapps" + File.separator + 
    						  "miniboard" + File.separator + "resources" + File.separator + "images" + File.separator;

    //  private String credentialsPath = "C:\\Users\\hanhu\\eclipse\\key.json";    
//    private String credentialsPath = "/var/lib/tomcat9/webapps/key.json";    
   // private String credentialsPath = "/usr/local/tomcat/webapps/key.json";    
//    private String credentialsPath = "/usr/local/tomcat/webapps/key.json";    
    private String credentialsPath = CATALINA_HOME + File.separator + "keys" + File.separator + "key.json";

	@Autowired
	public void setJdbctemplate(DataSource dataSource) {
		this.template=new JdbcTemplate(dataSource);
	}

	@Override
	public List<Post> getAllPosts(){
		String SQL="SELECT postId, title, writer, view, imageName FROM post";
		List<Post> listOfPosts=template.query(SQL, new PostListRowMapper());
		return listOfPosts;
	}
	public void createPost(Post post) {
		String SQL="INSERT INTO post (title, content, writer, imageName) VALUES (?,?,?,?)";
		template.update(SQL, post.getTitle(), post.getContent(), post.getWriter(), post.getImageName());
	}
	public Post getPostById(int postId) {
		Post postInfo=null;
		String SQL="SELECT count(*) FROM post where postId=?";
		int rowCount=template.queryForObject(SQL, Integer.class, postId);
		if(rowCount !=0) {
			SQL="SELECT * FROM post where postId=?";
			postInfo=template.queryForObject(SQL,  new Object[] {postId}, new PostRowMapper());
		}
		if(postInfo==null) {
			throw new IllegalArgumentException("post ID가 "+postId+"인 게시물를 찾을 수 없다.");
		}
		return postInfo;
	}
	public void addPostView(Post post) {
		String SQL="UPDATE post SET view = view + 1 WHERE postId = ?";
		template.update(SQL, post.getPostId());
	}
	public void deletePost(Post post) {
		String SQL="DELETE FROM post WHERE postId=?";
		template.update(SQL, post.getPostId());
	}
	public void saveAttachFile(Post post) {
		Random random = new Random();
        int randomNumber = random.nextInt();

        MultipartFile postImage=post.getPostImage();		
        String fileName=randomNumber+".jpg";

        File saveFile = new File(filePath, fileName);

        
        if(postImage !=null && !postImage.isEmpty()) {
        	try {
        		postImage.transferTo(saveFile);
        		post.setImageName(fileName);
        	}
        	catch(Exception e) {
        		throw new RuntimeException("이미지 업로드 실패", e);
        	}
    	    try {
    	    	CloudStorageUtil.uploadFile(filePath,fileName,credentialsPath);
    	    } catch (IOException e) {
    	        e.printStackTrace(); // 예외 처리 코드 작성
    	    }
        }
	}
	public void deleteAttachFile(Post post) {
	
        String fileName=post.getImageName();
        
        Path path = FileSystems.getDefault().getPath(filePath+fileName);
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
        	CloudStorageUtil.deleteFile(fileName,credentialsPath);
        }catch(IOException e) {
        	e.printStackTrace();
        }

	}
}
