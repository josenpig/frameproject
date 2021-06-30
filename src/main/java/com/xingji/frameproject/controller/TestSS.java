package com.xingji.frameproject.controller;

import com.xingji.frameproject.util.Constants;
import com.xingji.frameproject.mybatis.entity.Message1;
import com.xingji.frameproject.service.MessageService;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestSS {
//    @Autowired
//    private Message1 message=null;
//
//    @RabbitListener(queues = Constants.MAIL_QUEUE_NAME)
//    public void handler(Message1 msg){
//        message=msg;
//        String s="rO0ABXNyAC9jb20ueGluZ2ppLmZyYW1lcHJvamVjdC5teWJhdGlzLmVudGl0eS5NZXNzYWdlMQAAAAAAAAABAgAHTAADbWlkdAATTGphdmEvbGFuZy9JbnRl\n" +
//                "Z2VyO0wAB29yZGVyaWR0ABJMamF2YS9sYW5nL1N0cmluZztMAAlvcmRlcnR5cGVxAH4AAkwABnJlY3ZlcnEAfgABTAAGc2VuZGVycQB+AAFMAAhzZW5kdGlt\n" +
//                "ZXQAGUxqYXZhL3RpbWUvTG9jYWxEYXRlVGltZTtMAAZzdGF0dXNxAH4AAXhwc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBq\n" +
//                "YXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAAAAd0ABFDR0REMTYyNDgxMjk4MDY5MnQADOmHh+i0reiuouWNlXNxAH4ABQAAAAFxAH4ACnNyAA1qYXZh\n" +
//                "LnRpbWUuU2VylV2EuhsiSLIMAAB4cHcKBQAAB+UGHAA43XhzcQB+AAUAAAAA";
//        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+===>"+message.toString());
//    }

}
