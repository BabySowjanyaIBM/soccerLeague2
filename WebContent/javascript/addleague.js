function checkFields(){
				var year=document.getElementById("year").value;
				var title=document.getElementById("title").value;
				var season=document.getElementById("season").value;
				if(year==""){
					alert("Year Field cant be blank");
					return false;
				}
				else{
					if(isNaN(year)){
						alert("Year Field cant contain non-numerics");
						return false;
					}
					if(year.length>4){
						alert("Year field found too long");
						return false;
					}
				}
				if(title==""){
					alert("Title field cant be blank");
					return false;
				}
				if(season==""){
					alert("Season field cant be blank. Please select a season");
					return false;
				}
			}