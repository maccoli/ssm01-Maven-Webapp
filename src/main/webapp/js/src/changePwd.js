;(function(){
		function changepwd(){
			$('#changepwd').click(function(){
				changepwdajax();
				return false;
			});
		}
		changepwd();
	    function changepwdajax(){
	    	var oldword = $("#oldpwd").val();
	    	var newpwd = $("#newpwd").val();
	    	var newpwd2 = $("#newpwd2").val();
		    var data = {
		    		oldword:oldword,
		    		newpwd:newpwd
			    };
	        $.ajax({
	            url:'user/changepwd',
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