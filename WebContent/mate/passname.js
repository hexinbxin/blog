
  var xmlHttp;  
  function createXMLHttp(){	
  if(window.XMLHttpRequest){
	  xmlHttp = new XMLHttpRequest();
	  //alert(xmlHttp.responseText);
  }
  else{
	  xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
   }
  
  function passname(svalue){
	  createXMLHttp;
	  xmlHttp.open("get","Delete?uname="+svalue,true);
	  xmlHttp.onreadystatechange=function() {
		  if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			 
	  }
	 
	  
	  
  };  
  xmlHttp.send(null);
	  
  }
  