function setHiddenValue(input) {
    let list = input.getAttribute('list');
    let options = document.querySelectorAll('#' + list + ' option');
    let hiddenInput = document.getElementById(input.getAttribute('id') + '-hidden');
    let label = input.value;

    hiddenInput.value = label;

    for(let i = 0; i < options.length; i++) {
        let option = options[i];

        if(option.innerText === label) {
            hiddenInput.value = option.getAttribute('data-value');
            break;
        }
    }
    console.log("Hidden input value:"+hiddenInput.value);
}