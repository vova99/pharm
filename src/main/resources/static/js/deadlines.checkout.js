let tdsDate = document.getElementsByClassName('change-color');
const  today = new Date();
let tabVal;
for (let i = 0; i < tdsDate.length; i++) {
    tabVal = new Date(tdsDate[i].innerText);

    console.log("my:" +tabVal.getTime());
    console.log("tod:" +today.getTime());

    console.log("res: "+ (tabVal.getTime()-today.getTime()) / (1000 * 3600 * 24));

    if ((tabVal.getTime()-today.getTime()) / (1000 * 3600 * 24)<=10 && (tabVal.getTime()-today.getTime()) / (1000 * 3600 * 24)>=5){
        console.log("<10");
        tdsDate[i].closest('tr').classList.add("table-warning");
    }else if ((tabVal.getTime()-today.getTime()) / (1000 * 3600 * 24)<5) {
        console.log("<5");
        tdsDate[i].closest('tr').classList.add("table-danger");
    }
    else {
        console.log("ok")
    }
}