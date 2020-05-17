<?php
$error="";$successMessage="";

if($_POST){
    
     if(!$_POST['email']){
         
         $error .="An email address is required.<br>";
     }
     
     if($error != ""){
         
         $error = '<div class="alert alert-danger" role="alert"><p><strong>'.$error.'</div>';
         
     }
     else {
            
            $emailTo = $_POST['email'];
            
            
            $subject = "BookByChoice";
            
            
            $body = "Welcome to book by choice.Download the app now from the link here";
            
            
            
            $headers = "From: bookbychoice@gmail.com";
            
            if (mail($emailTo, $subject, $body, $headers)) {
                
                $successMessage = '<div class="alert alert-success" role="alert">Your message was sent, we\'ll get back to you ASAP!</div>';
                
                
            } else {
                
                $error = '<div class="alert alert-danger" role="alert"><p><strong>Your message couldn\'t be sent - please try again later</div>';
                
                
            }
            
        }
}


?>



<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/a499abd50b.js" crossorigin="anonymous"></script>


 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"
  />
  
  
   <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-scrollTo/1.4.3/jquery.scrollTo.min.js"></script>

<script src="/path/to/jquery.min.js"></script>
<script src="/path/to/bootstrap.min.js"></script>
<script src="./dist/jquery.smoothScroll.min.js"></script>

    <title>Book By Choice</title>
    <style type=text/css>
      
      html { 
  background: url(back.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}  
        
        body{
            
            
            background:none;
        }
        .container{
            
            text-align:center;
            
        }
        .jumbotron{
            background:none;
            
        }
        #exampleInputEmail1{
            
            width:300px;
            margin:10px;
        }
        .card{
            
            margin:20px;
        }
        #learn{
            
            margin-bottom:5px;
        }
        #footer{
            
            background-color:#A3A4A6;
        }
        #appIcon{
            
            width:300px;
            
        }
              </style>
  </head>
  <body>
    
           
            <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top" id="navbar-example">
                <div class="container">
  <a class="navbar-brand" href="#">Book By Choice</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">HOME <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#about">ABOUT</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#feature">FEATURES</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#team">TEAM</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#contact">CONTACT</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="#footer">DOWNLOAD</a>
      </li>
      
      
    </ul>
   
  </div>
  </div>
</nav>
 <div data-spy="scroll" data-target="#navbar-example" data-offset="150" class="scrollspy-example">
    <div class="container">

   <div class="jumbotron" id="jumbotron">
  
  <h1 class="display-4 wow animate__animated animate__zoomIn">Book By Choice</h1>
  <p class="lead">Get All the Second-hand books and stuff directly from your seniors</p>
  <hr class="my-4">
  <p>Want to know more?Join Our Mailing list!</p>
  <a class="btn btn-primary btn-lg" href="#" role="button"id="learn">Learn more</a>
    
<div id="error"><? echo $error.$successMessage; ?></div>
    <form method="post">
  <div class="form-group">
    
  <center>  <input type="email" name="email" class="form-control" id="exampleInputEmail1"  placeholder="Your Email" > </center>
    
  </div>
  
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div>
        
     <div class="container" id="about">
	       <div class="column" id="app">
		  <h1 class="wow animate__animated animate__slideInDown ">About</h1>
		   <hr class="my-4">
		   
		    <p class="lead">Ever wanted to buy a book but could not because it was too expensive? worry not! because BookByChoice is here! BookByChoice, these days in news,is being called as the Robinhood of the world of books especially for MNNIT.Our team is committed to bring to you all kinds of best books at the minimal prices ever seen anywhere. Yes, we are literally giving you away a steal</p>
		    <p class="lead">Yes, We are on App. Just Search on play store/ App Store & install BookByChoice App. Unlock lots of shopping options</p>
		  <h1>Why this App is Awesome</h1>
		   <p class="lead">No Commission..Buy and sell any book or any other essential thing through this app..Very useful app for freshers in MNNIT</p>
		   	     
		   </div>
		   
		   
		  <div class="card-group">
  <div class="card wow animate__animated animate__zoomIn animate__delay-1s " id="feature">
    <img src="card1.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">ScreenShots of app</h5>
      <p class="card-text">.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
      
    </div>
  </div>
  <div class="card wow animate__animated animate__zoomIn animate__delay-1s">
    <img src="card1.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">ScreenShots of app</h5>
      <p class="card-text">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
      
    </div>
  </div>
  <div class="card wow animate__animated animate__zoomIn animate__delay-1s ">
    <img src="card1.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">ScreenShots of app</h5>
      <p class="card-text">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
     
    </div>
  </div>
</div>
		   
		   
	   </div>
	   
	   <div class="jumbotron jumbotron-fluid" id="team">
  <div class="container">
    <h1 class="display-4 wow animate__animated animate__slideInRight ">Team(Error:404)</h1>
    <p class="lead font-weight-bold">Designer:Mradul,Darpan,Aditya,Jyoti</p>
     <p class="lead font-weight-bold">Content:Mradul,Darpan,Aditya,Jyoti</p>
      <p class="lead font-weight-bold">Development:Mradul,Darpan,Aditya,Jyoti</p>
  </div>
</div>


	   <div class="jumbotron jumbotron-fluid" id="contact">
  <div class="container">
    <h1 class="display-4 wow animate__animated animate__fadeIn animate__delay-1s ">Get in touch</h1>
    <p class="lead"> Want to get in touch?We'd love to hear from you.Here's how you can reach us..</p>
    <p class="lead font-weight-bold"> <a href="tel:8529467827"><i class="fas fa-phone"></i>  Call us :+91 8529467827</a></p>
    <p class="lead font-weight-bold"><a href="https://api.whatsapp.com/send?phone=+918529267827"><i class="fab fa-whatsapp"></i>    Or Whatsapp us</a></p>
  </div>
</div>

<div class="jumbotron jumbotron-fluid" id="footer">
  <div class="container">
    <h3 class="display-4">Download the app now</h3>
    <p class="lead font-weight-bold">Now available on playstore</p>
    <p><a href=""><img id="appIcon" src="dd.png"></a></p>
  </div>
</div>
</div>
	 
  
   <script>
$(function() {
  $('.scrollspy-example').smoothScroll({
    duration: 1000
  });
});
</script>
  
  
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.js"></script>
    
    <script>
    var wow = new WOW(
  {
    boxClass:     'wow',      // animated element css class (default is wow)
    animateClass: 'animated', // animation css class (default is animated)
    offset:       0,          // distance to the element when triggering the animation (default is 0)
    mobile:       true,       // trigger animations on mobile devices (default is true)
    live:         true,       // act on asynchronously loaded content (default is true)
    callback:     function(box) {
      // the callback is fired every time an animation is started
      // the argument that is passed in is the DOM node being animated
    },
    scrollContainer: null,    // optional scroll container selector, otherwise use window,
    resetAnimation: true,     // reset animation on end (default is true)
  }
);
wow.init();
    
    </script>
  </body>
</html>