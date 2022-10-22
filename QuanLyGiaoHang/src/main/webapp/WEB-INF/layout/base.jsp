<%-- 
    Document   : base
    Created on : Mar 31, 2022, 6:56:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css"><!--- fonts for slider on the index page -->  
  <!-- Fonts END -->

  <!-- Global styles START -->          
  <link href="<c:url value="resources/assets/plugins/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
  <link href="<c:url value="resources/assets/plugins/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href="<c:url value="resources/assets/pages/css/animate.css"/>" rel="stylesheet">
  <link href="<c:url value="resources/assets/plugins/fancybox/source/jquery.fancybox.css"/>" rel="stylesheet">
  <link href="<c:url value="resources/assets/plugins/owl.carousel/assets/owl.carousel.css"/>" rel="stylesheet">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="<c:url value="resources/assets/pages/css/components.css"/>" rel="stylesheet">
  <link href="<c:url value="resources/assets/pages/css/slider.css"/>" rel="stylesheet">
  <link href="<c:url value="resources/assets/pages/css/style-shop.css"/>" rel="stylesheet" type="text/css">
  <link href="<c:url value="resources/assets/corporate/css/style.css"/>" rel="stylesheet">
  <link href="<c:url value="resources/assets/corporate/css/style-responsive.css"/>" rel="stylesheet">
  <link href="<c:url value="resources/assets/corporate/css/themes/red.css"/>" rel="stylesheet" id="style-color">
  <link href="<c:url value="resources/assets/corporate/css/custom.css"/>" rel="stylesheet">
     

        
        

        

        
        <title><tiles:insertAttribute name="title"/></title>
    </head>
    <body class="ecommerce">
            <tiles:insertAttribute name="header" />

            <tiles:insertAttribute name="content" />

            <tiles:insertAttribute name="footer" />
            
      <script src="<c:url value="resources/assets/plugins/jquery.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="resources/assets/plugins/jquery-migrate.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="resources/assets/plugins/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>      
  <script src="<c:url value="resources/assets/corporate/scripts/back-to-top.js"/>" type="text/javascript"></script>
  <script src="<c:url value="resources/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.j"/>s" type="text/javascript"></script>
     END CORE PLUGINS 

     BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) 
    <script src="<c:url value="resources/assets/plugins/fancybox/source/jquery.fancybox.pack.js"/>" type="text/javascript"></script> pop up 
    <script src="<c:url value="resources/assets/plugins/owl.carousel/owl.carousel.min.js"/>" type="text/javascript"></script> slider for products 
    <script src='<c:url value="resources/assets/plugins/zoom/jquery.zoom.min.js"/>' type="text/javascript"></script> product zoom 
    <script src="<c:url value="resources/assets/plugins/bootstrap-touchspin/bootstrap.touchspin.js"/>" type="text/javascript"></script> Quantity 

    <script src="<c:url value="resources/assets/corporate/scripts/layout.js"/>" type="text/javascript"></script>
    <script src="<c:url value="resources/assets/pages/scripts/bs-carousel.js"/>" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            Layout.initImageZoom();
            Layout.initTouchspin();
            Layout.initTwitter();
        });
    </script>        
    
        <script src="<c:url value="/js/main.js"/>"></script>
        
        
        
    </body>
    
    
    
    
</html>
