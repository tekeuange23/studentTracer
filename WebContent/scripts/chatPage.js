$(document).ready(function(){
	$('#action_menu_btn').click(function(){
		$('.action_menu').toggle();
	});
});





console.log('<SAlle Management>{');//////////////////////////////   SALLE 	//////////////////////////////

const hiddenInput = document.getElementById('salle');
const formSalle = document.getElementById('formSalle');
const items = document.getElementsByClassName("salleItem");

const changeHiddenInputValue = (value) => {
	hiddenInput.value = value;
	formSalle.submit();
	console.log(`SALLE: ${value}`);
}


console.log('}</SAlle Management>');//////////////////////////////////////////////////////////////////////
