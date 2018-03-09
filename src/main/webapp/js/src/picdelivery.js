;(function(){
		function picdelivery(){
			
			$('#searchCountry').click(function(){
				console.log("a");
				picdeliveryAjax();
				console.log("e");
				return false;
			});
		}
		picdelivery();
	    function picdeliveryAjax(){
	    	var id = $("#countryid").val();
	    	console.log("w");
		    var data = {
		    		id:id
			    };
	        $.ajax({
	            url:'country/oneCountryById',
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