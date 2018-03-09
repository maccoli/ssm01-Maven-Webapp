;(function(){
		function login(){
			$('#login').click(function(){
				loginajax();
				return false;
			});
		}
		login();
	    function loginajax(){
	    	var password = $("#password").val();
	    	var username = $("#username").val();
	    	var checkcode = $("#checkcode").val();
	    	var data = $('#form1').serialize();
/*		    var data = {
			    	username:username,
			    	password:password,
			    	checkcode:checkcode
			    };*/
	        $.ajax({
	            url:'user/login',
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
	    
	    
		function picdelivery(){
			
			$('#searchCountry').click(function(){
				picdeliveryAjax();
				return false;
			});
		}
		picdelivery();
	    function picdeliveryAjax(){
	    	var id = $("#countryid").val();
		    var data = {
		    		id:id
			    };
	        $.ajax({
	            url:'country/oneCountryById',
	            type:'post',
	            data:data,
	            success:function(data){
	                console.log(data);
	                console.log(data.mianpic);
	                $(function(){
	                	  $('#aa').attr("src",data.mianpic);
	                	});
	            },
	            error:function(err){
	                console.log(err);
	            }
	        });
	    }
	    
})();