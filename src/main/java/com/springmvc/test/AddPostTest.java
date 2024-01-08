package com.springmvc.test;

import com.springmvc.domain.Post;
import com.springmvc.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:C:\\Users\\hanhu\\spring-project\\spring-project\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml",
        "file:C:\\Users\\hanhu\\spring-project\\spring-project\\src\\main\\webapp\\WEB-INF\\spring\\appServlet\\servlet-context.xml"
})

public class AddPostTest {

    @Autowired
    private PostService postService;

	@Autowired
	private ApplicationContext ctx;
	
    @Test
    public void test() {
    	Post p=new Post();
    	p.setTitle("aa");
    	p.setContent("aa content");
    	p.setWriter("aa writer");
        postService.createPost(p);
        System.out.println("aa");
    }
}

