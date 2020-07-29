const validateMovieModal = document.getElementById('validate-modal');
const backDrop = document.getElementById('backdrop');
const buttons = document.querySelectorAll('.modal #buttons');

const startValidateModal = document.getElementById('startModal');


const toggleValidationModal = () =>{
  addMovieModal.classList.toggle('visible');
  backDrop.classList.toggle('visible');
}

//startValidateModal.addEventListener('click', toggleValidationModal);
//backDrop.addEventListener('click', toggleValidationModal);
//buttons[0].addEventListener('click', toggleValidationModal);