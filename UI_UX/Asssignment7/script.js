
let currentTab = 0; // Current tab is set to be the first tab (0)
 // Display the current tab
let type;
let pack;
let name1;
let cur;
let showTab=(n)=> {
    // This function will display the specified tab of the form...
    let x = document.getElementsByClassName("tab");
    x[n].style.display = "block";
    //... and fix the Previous/Next buttons:
    if (n == 14) {
        getname();
        document.getElementById("employeeid").innerHTML = '<h2 style="color:black ">Congratulations ' + name1 + '</h3><br><p>You have been assigned a pass</p>';
        document.getElementById("nextBtn").style.display = "none";
        document.getElementById("getpass").style.display = "none";
        let temp = document.getElementsByClassName("collapsible");
        let i = 0;
        for (i = 0; i < temp.length; i++) {
            temp[i].style.display = "none";
        }
    }
    if (n == 5) {
        document.getElementById("nextBtn").innerHTML = "Submit";
    }
    else {
        document.getElementById("nextBtn").innerHTML = "Next";
    }
    if (n == 6) {
        document.getElementById("employeeid").innerHTML = '<h2 style="color:black">Emp-1</h3>';
    }
    //... and run a function that will display the correct step indicator:
    if (n <= 10) {
        let input = document.getElementsByClassName("input1");
        console.log(n);
        input[n].addEventListener("keyup", function (event) {
            if (event.keyCode == 13) {
                event.preventDefault();
                document.getElementById("nextBtn").click();
            }
        });
    }
}
showTab(currentTab);
let nextPrev=(n)=> {
    // This function will figure out which tab to display
    let x = document.getElementsByClassName("tab");
    // Exit the function if any field in the current tab is invalid:
    if (currentTab < 12) {
        if (n == 1 && !validateForm())
            return false;
    } // Hide the current tab:
    if (currentTab < 13) {
        x[currentTab].style.display = "none";
    }
    // Increase or decrease the current tab by 1:
    currentTab = currentTab + n;
    // if you have reached the end of the form...
    // Otherwise, display the correct tab:
    showTab(currentTab);
}
let validateForm=()=> {
    // This function deals with validation of the form fields
    let x, y, i, mailformat, paswd, valid = true;
    x = document.getElementsByClassName("tab");
    y = x[currentTab].getElementsByTagName("input");
    mailformat = /^[a-zA-Z0-9.!#$%&'*+=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    paswd = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$/;
    // A loop that checks every input field in the current tab:
    for (i = 0; i < y.length; i++) {
        // If a field is empty...
        if (y[i].id == "ename") {
            if (y[i].value == "" || y[i].value.length < 2 || (y[i].value >= '0' && y[i].value <= '9')) {
                y[i].className += "invalid";
                valid = false;
            }
        }
        else if (y[i].id == "email") {
            if (!y[i].value.match(mailformat)) {
                y[i].className += "invalid";
                valid = false;
            }
        }
        else if (y[i].id == "contact") {
            if (y[i].value.length < 8 || (y[i].value <= '0' && y[i].value >= '9')) {
                y[i].className += "invalid";
                valid = false;
            }
        }
        else if (y[i].id == "password") {
            if (!y[i].value.match(paswd)) {
                y[i].className += "weak";
                valid = false;
            }
            else {
                if (y[i].value.match(paswd) && y[i].value.length == 8)
                    y[i].className = "ok";
                else
                    y[i].className = "strong";
            }
        }
        else {
            if (y[i].value == "") {
                // add an "invalid" class to the field:
                y[i].className += "invalid";
                // and set the current valid status to false
                valid = false;
            }
        }
    }
    return valid; // return the valid status
}
let getValue=()=> {
    let temp = document.getElementById('type');
    type = temp.value;
}
let pricing=()=> {
    console.log(type);
    getValue();
    if (type == "cycle") {
        document.getElementById("pricetab").innerHTML = '<div class="column">' + '<h4 style="color:black;">CYCLE</h3>' +
            '<h4>$5 Daily</h4>' +
            '<h4>$100 Monthly</h4>' +
            '<h4>$500 Yearly</h4>' +
            '<p class="pbutton">Change Currency</p>' +
            '<p><select name="currency"  oninput="getcur()" id="currency">' +
            '<option value="USD" >USD</option>' +
            '<option value="YEN" >YEN</option>' +
            '</select>' + '</p>' +
            'Vehicle Price:' +
            '<p><select name="type" oninput="getPack()" id="vpack">' +
            '<option value="5" class="pbutton">$5 Daily</option>' +
            '<option value="100" class="pbutton">$100 Monthly</option>' +
            '<option value="500" class="pbutton">$500 Yearly</option>' +
            '</select>' + '</p>' + '</div>';
    }
    else if (type == "motorcycle") {
        document.getElementById("pricetab").innerHTML = '<div class="column">' + '<h4 style="color:black;">MOTOR-CYCLE</h3>' +
            '<h4>$10 Daily</h4>' +
            '<h4>$200 Monthly</h4>' +
            '<h4>$1000 Yearly</h4>' +
            '<p class="pbutton">Change Currency</p>' +
            '<p><select name="currency"  oninput="getcur()" id="currency">' +
            '<option value="USD" class="pbutton">USD</option>' +
            '<option value="YEN" class="pbutton">YEN</option>' +
            '</select>' + '</p>' +
            'Vehicle Price:' +
            '<p><select name="type" oninput="getPack()" id="vpack">' +
            '<option value="10" class="pbutton">$10</option>' +
            '<option value="200" class="pbutton">$200</option>' +
            '<option value="1000" class="pbutton">$1000</option>' +
            '</select>' + '</p>' + '</div>';
    }
    else if (type == "fourwheeler") {
        document.getElementById("pricetab").innerHTML = '<div class="column">' + '<h4 style="color:black;">FOUR-WHEELER</h3>' +
            '<h4>$20 Daily</h4>' +
            '<h4>$500 Monthly</h4>' +
            '<h4>$3500 Yearly</h4>' +
            '<p class="pbutton">Change Currency</p>' +
            '<p><select name="currency"  oninput="getcur()" id="currency">' +
            '<option value="USD" class="pbutton">USD</option>' +
            '<option value="YEN" class="pbutton">YEN</option>' +
            '</select>' + '</p>' +
            'Vehicle Price:' +
            '<p><select name="type" oninput="getPack()" id="vpack">' +
            '<option value="20" class="pbutton">$20</option>' +
            '<option value="500" class="pbutton">$500</option>' +
            '<option value="3500" class="pbutton">$3500</option>' +
            '</select>' + '</p>' + '</div>';
    }
}
let getPack=()=> {
    var temp = document.getElementById('vpack');
    pack = temp.value;
}
let getcur=()=> {
    var temp = document.getElementById('currency');
    cur = temp.value;
}
let getname=()=> {
    var temp = document.getElementById('ename');
    name1 = temp.value;
}
let price=()=> {
    var temp = document.getElementById("getpass");
    temp.innerHTML = pack + cur;
}
