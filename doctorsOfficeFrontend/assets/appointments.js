function loadData(){
    let request = sendRequest('appointment/list', 'GET', '');
    let table = document.getElementById('appointmentsTable');
    table.innerHTML = "";
    request.onload = function(){

        let data = request.response;
        data.forEach((element) => {
            table.innerHTML += `
            <tr>
                <td class='text-center'>${element.date}</td>
                <td class='text-center'>${element.hour}</td>
                <td class='text-center'>${element.doctor.doctorName}</td>
                <td class='text-center'>${element.patient.patientName}</td>
                <td class='text-center'>
                    <a href="../appointments/create.html?id=${element.appointmentId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deleteAppointment(${element.appointmentId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
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
function loadDoctors(){
    let request = sendRequest('doctor/list', 'GET', '');
    let selectDoctor = document.getElementById('selectDoctor');
    selectDoctor.innerHTML = "";
    request.onload = function(){

        let data = request.response;

        data.forEach(element => {
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
function loadPatients(){
    let request = sendRequest('patient/list', 'GET', '');
    let selectPatient = document.getElementById('selectPatient');
    selectPatient.innerHTML = "";
    request.onload = function(){

        let data = request.response;

        data.forEach(element => {
            selectPatient.innerHTML += `
             <option value="${element.patientId}">${element.patientName}</option>
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

function loadAppointment(idAppointment) {
    let request = sendRequest('appointment/list/'+idAppointment, 'GET', '');
    let id = document.getElementById('inputId');
    let date = document.getElementById('inputDate');
    let hour = document.getElementById('inputHour');
    let doctor = document.getElementById('selectDoctor');
    let patient = document.getElementById('selectPatient');

    
    request.onload = function () {
        let data = request.response;
        id.value = data.appointmentId;
        date.value = data.date;
        hour.value = data.hour;
        doctor.value = data.doctor.doctorId;
        patient.value = data.patient.patientId;
    }
    request.onerror = function(){
        alert("Error al recuperar los datos");
    }
}

function deleteAppointment(idAppointment){
    let request =  sendRequest('appointment/'+idAppointment, 'DELETE','');
    request.onload = function () {
        loadData();
    }
}

function saveAppointment(){
    
    let date = document.getElementById('inputDate').value
    let hour = document.getElementById('inputHour').value
    let doctor = document.getElementById('selectDoctor').value
    let patient = document.getElementById('selectPatient').value

    let data = {
        "date":date,
        "hour":hour,
        "patient":{
            "patientId":patient
        },
        "doctor":{
            "doctorId":doctor
        }
    }
    
    let request = sendRequest('appointment/','POST', data)

    request.onload = function(){
        window.location = '../appointments/index.html';
    }
    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}

function editAppointment() {
    let id = document.getElementById('inputId').value
    let date = document.getElementById('inputDate').value
    let hour = document.getElementById('inputHour').value
    let doctor = document.getElementById('selectDoctor').value
    let patient = document.getElementById('selectPatient').value

    let data = {
        "appointmentId":id,
        "date":date,
        "hour":hour,
        "patient":{
            "patientId":patient
        },
        "doctor":{
            "doctorId":doctor
        }
    }

    let request = sendRequest('appointment/',id ? 'PUT':'POST', data)

    request.onload = function(){
        window.location = '../appointments/index.html';
    }

    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}
function loadAppointmentByPatientName(){

    let request = sendRequest('appointment/list', 'GET', '');
    let divTable = document.getElementById('spaceTable');
    let name = document.getElementById('inputName').value;
    let data;

    request.onload = function () {
        if(name == ''){
            alert('Por favor llena el campo de búsqueda')
        }else{
            data = request.response;
            let appointment;
            for (let index = 0; index < data.length; index++) {
                const element = data[index];
                if(element.patient.patientName.trim().toUpperCase() == name.trim().toUpperCase()){
                    appointment = element;
                }
            }
            if(appointment != undefined || appointment != null){
            divTable.innerHTML = `
         <table class="table table-dark table-hover table-sm">
            <thead>
                <tr>
                    <th class="text-center">Date</th>
                    <th class="text-center">Hour</th>
                    <th class="text-center">Doctor</th>
                    <th class="text-center">Patient</th>
                    <th class="text-center"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="">${appointment.date}</td>
                    <td class="text-center">${appointment.hour}</td>
                    <td class="text-center">${appointment.patient.patientName}</td>
                    <td class="text-center">${appointment.doctor.doctorName}</td>
                    <td class="text-center">
                    <a href="../medicines/create.html?id=${appointment.appointmentId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deleteMedicine(${appointment.appointmentId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
                    </td>
                 </tr>                    
            </tbody>
         </table>
         `;
            }else{
                alert("El usuario no tiene citas");
            }
        }
        
    } 
}