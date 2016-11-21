/**
 * 
 */

function myFunction() {
	var text = document.getElementById("demo").innerHTML;
    if(text.match("Watched Movies")){
    	document.getElementById("demo").innerHTML = "Seen Movies";
    }
    else{    	
    	document.getElementById("demo").innerHTML = "Watched Movies";
    	
}
}
function myDateCheck(){
	var number = document.getElementById("totalunmovies").innerHTML;
	
	for(var i=0; i<number; i++){
	var date_st = document.getElementById("releaseDate["+i+"]").innerHTML;
	var dt = new Date(date_st);
	
	}
	
}
