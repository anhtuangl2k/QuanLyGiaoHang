<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  
        
        
<form class="form-group">  
    <textarea class="form-control" placeholder="Nhập bình luận" id="commentID"></textarea>
    <br>
    <input type="submit" value="Gửi bình luận" class="btn btn-danger" onclick="addComment(${receipt.id})"/>
</form>

<div id="commentArea">
    <c:forEach items="${receipt.commentCollection}" var="r">
        <div class="row">
            <div class="col-md-3">
                <img class="rounded-circle" src="" />
            </div>
            <div class="col-md-10 mydate">
                <p>${r.content}</p>
                <i>${r.dateTime}</i>
            </div>
        </div>
    </c:forEach>
</div>


<script>
    window.onload() = function (){
        let dates = document.querySelectorAll(".mydate > i");
            for(let i =0; i< dates.length; i++){
                let d = dates[i]
                d.innerText = moment(d.innerText).fromNow();
            }
    }


</script>