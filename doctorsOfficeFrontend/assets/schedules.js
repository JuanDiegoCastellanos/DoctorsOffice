function loadData(){
    let request = sendRequest('schedule/list', 'GET', '');
    let table = document.getElementById('schedulesTable');
    table.innerHTML = "";
    request.onload = function(){

        let data = request.response;
        data.forEach((element,index) => {
            table.innerHTML += `
            <tr>
                <td class='text-center'>${element.scheduleWeek}</td>
                <td class='text-center'>${element.scheduleDay}</td>
                <td class='text-center'>${element.scheduleHour}</td>
                <td class='text-center'>${element.doctor.doctorName}</td>
                <td class='text-center'>
                    <a href="../schedules/create.html?id=${element.scheduleId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deleteSchedule(${element.scheduleId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
                </td>
            </tr>
            `   
        }
        );
        request.onerror = function(){
            table.innerHTML = `
            <tr>
                <td colspan="6">
                    Error on load the data
                </td>   
            </tr>
            `;
        }
    }
}

function loadScheduleDoctorByName(){

    let request = sendRequest('schedule/list', 'GET', '');
    let divTable = document.getElementById('spaceTable');
    let name = document.getElementById('inputName').value;
    let data;
    request.onload = function () {
        if(name == ''){
            alert('Por favor llena el campo de búsqueda')
        }else{
            data = request.response;
            let schedule;
            for (let index = 0; index < data.length; index++) {
                const element = data[index];
                if(element.doctor.doctorName.trim().toUpperCase() == name.trim().toUpperCase()){
                    schedule = element;
                }
            }
            if(schedule != undefined || schedule != null){
                divTable.innerHTML = `
                <table class="table table-dark table-hover table-sm">
            <thead>
                <tr>
                    <th class="text-center" >Week</th>
                    <th class="text-center" >Day</th>
                    <th class="text-center" >Hour</th>
                    <th class="text-center" >Doctor</th>
                    <th class="text-center" ></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="" >${schedule.scheduleWeek}</td>
                    <td class="text-center">${schedule.scheduleDay}</td>
                    <td class="text-center">${schedule.scheduleHour}</td>
                    <td class="text-center">${schedule.doctor.doctorName}</td>
                    <td class="text-center">
                    <a href="../schedules/create.html?id=${schedule.scheduleId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deleteSchedule(${schedule.scheduleId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
                    </td>
                 </tr>                    
            </tbody>
         </table>
                `;
                
            }else{
                alert("El doctor no existe")
            }
        }
        
    } 
}

function loadDoctors(){
    let request = sendRequest('doctor/list', 'GET', '');
    let selectDoctor = document.getElementById('inputDoctor');
    selectDoctor.innerHTML = "";
    request.onload = function(){

        let data = request.response;

        data.forEach((element,index) => {
            selectDoctor.innerHTML += `
             <option value="${element.doctorId}">${element.doctorName}</option>
            `   
        }
        );
        request.onerror = function(){
            table.innerHTML = `
            <tr>
                <td colspan="6">
                    Error on load the data
                </td>   
            </tr>
            `;
        }
    }
}

function loadSchedule(idSchedule) {
    let request = sendRequest('schedule/list/'+idSchedule, 'GET', '');
    let id = document.getElementById('inputId');
    let week = document.getElementById('inputWeek');
    let day = document.getElementById('inputDay');
    let hour = document.getElementById('inputHour');
    let doctor = document.getElementById('inputDoctor');

    
    request.onload = function () {
        let data = request.response;
        id.value = data.scheduleId;
        week.value = data.scheduleWeek;
        day.value = data.scheduleDay;
        hour.value = data.scheduleHour;
        doctor.value = data.doctor.doctorId;
    }
    request.onerror = function(){
        alert("Error al recuperar los datos");
    }
}

function deleteSchedule(idSchedule){
    let request =  sendRequest('schedule/'+idSchedule, 'DELETE','');
    request.onload = function () {
        loadData();
    }
}

function saveSchedule(){
    
    let week = document.getElementById('inputWeek').value
    let day = document.getElementById('inputDay').value
    let hour = document.getElementById('inputHour').value
    let doctor = document.getElementById('inputDoctor').value

    let data = {
        "scheduleWeek":week,
        "scheduleDay":day,
        "scheduleHour":hour,
        "doctor":{
            "doctorId":doctor
        }
    }
    
    let request = sendRequest('schedule/','POST', data)

    request.onload = function(){
        window.location = '../schedules/index.html';
    }
    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}

function editSchedule() {
    let id = document.getElementById('inputId').value
    let week = document.getElementById('inputWeek').value
    let day = document.getElementById('inputDay').value
    let hour = document.getElementById('inputHour').value
    let doctor = document.getElementById('inputDoctor').value

    let data = {
        "scheduleId":id,
        "scheduleWeek":week,
        "scheduleDay":day,
        "scheduleHour":hour,
        "doctor":{
            "doctorId":doctor
        }
    }

    let request = sendRequest('schedule/',id ? 'PUT':'POST', data)

    request.onload = function(){
        window.location = '../schedules/index.html';
    }

    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}