/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service;

import com.tdd.pojos.Comment;


public interface CommentService {
    Comment addComment(String content, Integer receiptID); 
}
