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
                
                
             }
             else {
                
                $error = '<div class="alert alert-danger" role="alert"><p><strong>Your message couldn\'t be sent - please try again later</div>';
                
                
            }
            
        }
      }


?>
