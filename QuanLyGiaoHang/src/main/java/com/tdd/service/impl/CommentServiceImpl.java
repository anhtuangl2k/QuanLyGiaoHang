/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service.impl;

import com.tdd.pojos.Account;
import com.tdd.pojos.Comment;
import com.tdd.pojos.Receipt;
import com.tdd.repository.AccountResponsitory;
import com.tdd.repository.CommentResponsitory;
import com.tdd.repository.ReceiptResponsitory;
import com.tdd.service.CommentService;
import com.tdd.utils.Utils;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    private CommentResponsitory commentResponsitory;
    @Autowired
    private AccountResponsitory accountResponsitory;
    @Autowired
    private ReceiptResponsitory receiptResponsitory;

    @Override
    public Comment addComment(String content, Integer receiptID) {
        Comment c = new Comment();
        c.setDateTime(new Date());
        c.setContent(content);
        if(Utils.ACCOUNT_LOGIN == null)
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();  
            Utils.ACCOUNT_LOGIN = this.accountResponsitory.getAccounts(authentication.getName()).get(0);

        }
        c.setAccountID(Utils.ACCOUNT_LOGIN);
        Receipt r = this.receiptResponsitory.getReceiptById(receiptID);
        if(r != null){
            c.setReceiptsID(r);
        }
        return this.commentResponsitory.addComment(c);
    }
    
}
