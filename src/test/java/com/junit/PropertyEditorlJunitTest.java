package com.junit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.domain.PersonEntity;
import com.demo.domain.Telephone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring-context.xml")
public class PropertyEditorlJunitTest {

	@Resource
	private PersonEntity personEntity;

	@Test
	public void test() {
		Telephone telephone = personEntity.getTelephone();
		System.out.printf("区号:%s，号码：%s\n", telephone.getAreaCode(), telephone.getPhone());
	}

}
