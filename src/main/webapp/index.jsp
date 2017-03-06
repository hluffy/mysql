<html>
<script src="js/jquery-2.1.4.min.js"></script>
<body>
<h2>Hello World!</h2>
</body>
<script>
	$(function(){
		var data = {"equipmentNo":"23243tdssdf3423","date":"5sdf56666" };
		
// 		data = $.parseJSON(data);
		console.log($.parseJSON(data));
		
		
		var data = {"equipmentNo":"23243tdssdf3423","date":"5sdf56666" };
		
// 		console.log(JSON.stringify(data));
// 		console.log(JSON.parse(data));
// 		console.log(eval('(' + data + ')'))
		$.ajax({
			type:"post",
			dataType: "json",
			contentType: "application/json;charset=utf-8",

			url:"http://localhost:8080/mysql/socketgps/save.ll",
			data:{"equipmentNo":"2323423","date":"222222","Time":"556666","isPosition":"V","latitude":"31.5564727488","longitude":"121.9987766655"},
// 			data:JSON.stringify({"equipmentNo":"23243tdssdf3423","date":"5sdf56666"}),
			success:function(result){
				console.log(result);
			}
		});
	});
	
	

</script>
</html>
