async function createroom() {
    var roomname=document.getElementById("roomname").value;
    var maxmemb=document.getElementById("maxnum").value;
    console.log(name+" "+maxmemb);
    var url="/roomchat"+"/room"+`?roomname=${roomname}&maxmemb=${maxmemb}`;
    var response=await fetch(url,{method:"POST"});
    location.reload();
}

var saveddata;
async function openpopup(Rooms, hotelname) {
        const rooms = Rooms;
        const selectElement = document.getElementById("select");
        Object.keys(rooms).forEach(roomNumber => {
            if (!rooms[roomNumber]) {
                const optionElement = document.createElement('option');
                optionElement.value = roomNumber;
                optionElement.textContent = roomNumber;
                selectElement.appendChild(optionElement);
            }
        });
        var title= document.getElementById("title");
        title.innerText=hotelname;
    document.querySelector(".popup").style.display = "flex";
}
window.onload = async function () {
    const response = await fetch('/hotels', { method: 'GET' });
    const data = await response.json();
    console.log(data);
    saveddata=data;
    createfieldsets(saveddata);
}
async function submitreserve(){
    var select = document.getElementById("select");
    var value=select.value;
    var hotelname=document.getElementById("title").innerText;
    const response = await  fetch('/rooms'+'/'+hotelname+`?roomnum=${value}`,{method:'POST'});
    document.querySelector(".popup").style.display = "none";
}
async function createfieldsets(rooms) {
    const roomdiv = document.getElementById("roomdiv");
    rooms.forEach(item => {

        const fieldset = document.createElement("fieldset");
        fieldset.classList.add("forfieldset");

        const chatname = document.createElement("label");
        chatname.textContent = item.name;
        fieldset.appendChild(chatname);

        const members = document.createElement("label");
        members.textContent = "/"+item.maxrooms;
        members.style.position = "absolute";
        members.style.right = "5px";
        fieldset.appendChild(members);
        fieldset.onclick=function (){
            openpopup(item.rooms, item.name);
        }
        roomdiv.appendChild(fieldset);
    });
}