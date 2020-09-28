const people = [
    { name: 'google', link: "https://www.google.com/"},
    { name: 'googel', link: "https://www.google.com/"},
    { name: 'youtube', link: "https://www.youtube.com/"}
    ];
    
    const list = document.getElementById('list');
    
    function setList(group) {
        clearList();
        for (const person of group) {
            var item = document.createElement('a');
            item.href = person.link;
            item.classList.add('list-group-item');
            const text = document.createTextNode(person.name);
            item.appendChild(text);
            list.appendChild(item);
            
        }
        if (group.length === 0){
            setNoResults();
        }
    }
    
    
    function clearList() {
        while(list.firstChild){
        list.removeChild(list.firstChild);
        }
    }
    
    function setNoResults() {
            const item = document.createElement('li');
            item.classList.add('list-group-item');
            const text = document.createTextNode("Не знайдено");
            item.appendChild(text);
            list.appendChild(item);
    }
    
    function getRelevancy(value,searchTerm) {
        if (value === searchTerm) {
            return 2;
        } else if (value.starsWith(searchTerm)) {
            return 1;
        } else if (value.includes(searchTerm)) {
            return 0;
        }
    }
    
    
    const searchInput = document.getElementById('search');
    
    searchInput.addEventListener('input', (event) => {
    let value = event.target.value;
        if (value && value.trim().length > 0) {
            value = value.trim().toLowerCase();
            setList(people.filter(person =>{
                return person.name.includes(value);
            }).sort((personA, personB) => {
                return getRelevancy(personB.name, value) - getRelevancy(personA.name, value);
            
            }));
        
        } else {
        clearList();
        }
    });

    searchInput.addEventListener("focusout", function(){
        clearList();
    } );


    function sendCallBackRequest() {
        var contactPerson = $('#contactPersonName').val();
        var contactPhone = $('#contactPersonPhone').val();

        $.ajax({
            method: "post",
            url: "/sendCallback",
            contextType: "application/json",
            data: {
                contactPerson: contactPerson,
                contactPhone: contactPhone,
            },
            traditional: true,
            success: function () {
                $('#callBackModal').modal('hide');
                $('#thanksModal').modal('show');
            },
            error: function () {
                alert("Error");
            }
        });
    }