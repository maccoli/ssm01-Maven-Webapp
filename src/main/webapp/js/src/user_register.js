;(function(){
		function register(){
			$('#register').click(function(){
				registerajax();
				return false;
			});
		}
		register();
	    function registerajax(){
	    	var email = $("#email").val();
	    	var username = $("#username").val();
	    	var pwd = $("#password").val();
	    	var checkcode = $("#checkcode").val();
		    var data = {
		    		useremail:email,
		    		username:username,
		    		userpassword:pwd,
		    		checkcode:checkcode
			    };
	        $.ajax({
	            url:'user/register',
	            type:'post',
	            data:data,
	            success:function(data){
	                console.log(data);
	            },
	            error:function(err){
	                console.log(err);
	            }
	        });
	    }
	    
})();