function loadData(){
    let request = sendRequest('doctor/list', 'GET', '');
    let table = document.getElementById('doctorsTable');
    table.innerHTML = "";
    request.onload = function(){

        let data = request.response;
        data.forEach((element,index) => {
            table.innerHTML += `
            <tr>
                <td class='text-center'>${element.doctorName} ${element.doctorLastname}</td>
                <td class='text-center'>${element.doctorAge}</td>
                <td class='text-center'>${
                    element.doctorGender == 1 ? 'Femenino': element.doctorGender == 2 ? 'Masculino':'NN'
                }</td>
                <td class='text-center'>${element.doctorDocumentType} ${element.doctorDocument}</td>
                <td class='text-center'>${element.doctorPhoneNumber}</td>
                <td class='text-center'></td>
                <td class='text-center'>
                    <a href="../doctors/create.html?id=${element.doctorId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deleteDoctor(${element.doctorId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
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

function loadDoctorByName(){

    let request = sendRequest('doctor/list', 'GET', '');
    let divTable = document.getElementById('spaceTable');
    let name = document.getElementById('inputName').value;
    let data;
    request.onload = function () {
        if(name == ''){
            alert('Por favor llena el campo de búsqueda')
        }else{
            data = request.response;
            let doctor;
            for (let index = 0; index < data.length; index++) {
                const element = data[index];
                if(element.doctorName.trim().toUpperCase() == name.trim().toUpperCase()){
                    doctor = element;
                }
            }
            if(doctor != undefined || doctor != null){
            divTable.innerHTML = `
         <table class="table table-dark table-hover table-sm">
            <thead>
                <tr>
                    <th class="text-center" >Full Name</th>
                    <th class="text-center" >Age</th>
                    <th class="text-center" >Gender</th>
                    <th class="text-center" >Document</th>
                    <th class="text-center" >Phone Number</th>
                    <th class="text-center" ></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="" >${doctor.doctorName + " " + doctor.doctorLastname}</td>
                    <td class="text-center">${doctor.doctorAge}</td>
                    <td class="text-center">${
                        doctor.doctorGender == 1 ? 'Femenino': doctor.doctorGender == 2 ? 'Masculino':'NN'
                    }</td>
                    <td class="text-center">${doctor.doctorDocument}</td>
                    <td class="text-center">${doctor.doctorDocumentType}</td>
                    <td class="text-center">
                    <a href="../doctors/create.html?id=${doctor.doctorId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deleteDoctor(${doctor.doctorId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
                    </td>
                 </tr>                    
            </tbody>
         </table>
         `;
            }
            else{
                alert("No existe el doctor");
            }
        }
        
    } 
}

function loadDoctor(idDoctor) {
    let request = sendRequest('doctor/list/'+idDoctor, 'GET', '');
    let id = document.getElementById('inputId');
    let name = document.getElementById('inputName');
    let lastName = document.getElementById('inputLastName');
    let age = document.getElementById('inputAge');
    let documentField = document.getElementById('inputDocument');
    let documentType = document.getElementById('inputDocumentType');
    let phoneNumber = document.getElementById('inputPhone');
    let gender = document.getElementById('selectGender');
    
    request.onload = function () {
        let data = request.response;
        id.value = data.doctorId;
        name.value = data.doctorName;
        lastName.value = data.doctorLastname;
        age.value = data.doctorAge;
        documentField.value = data.doctorDocument;
        documentType.value = data.doctorDocumentType;
        phoneNumber.value = data.doctorPhoneNumber;
        gender.value = data.doctorGender;

    }
    request.onerror = function(){
        alert("Error al recuperar los datos");
    }
}

function deleteDoctor(idDoctor){
    let request =  sendRequest('doctor/'+idDoctor, 'DELETE','');
    request.onload = function () {
        loadData();
    }
}

function saveDoctor(){
    let name = document.getElementById('inputName').value
    let lastName = document.getElementById('inputLastName').value
    let age = document.getElementById('inputAge').value
    let documentField = document.getElementById('inputDocument').value
    let documentType = document.getElementById('inputDocumentType').value
    let phoneNumber = document.getElementById('inputPhone').value
    let gender = document.getElementById('selectGender').value

    let data = {
        "doctorName":name,
        "doctorLastname":lastName,
        "doctorAge":age,
        "doctorGender":gender,
        "doctorDocument":documentField,
        "doctorDocumentType":documentType,
        "doctorPhoneNumber":phoneNumber,
    }

    let request = sendRequest('doctor/','POST', data)

    request.onload = function(){
        window.location = '../doctors/index.html';
    }
    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}

function editDoctor() {
    let id = document.getElementById('inputId').value
    let name = document.getElementById('inputName').value
    let lastName = document.getElementById('inputLastName').value
    let age = document.getElementById('inputAge').value
    let documentField = document.getElementById('inputDocument').value
    let documentType = document.getElementById('inputDocumentType').value
    let phoneNumber = document.getElementById('inputPhone').value
    let gender = document.getElementById('selectGender').value

    let data = {
        "doctorId":id,
        "doctorName":name,
        "doctorLastname":lastName,
        "doctorAge":age,
        "doctorGender":gender,
        "doctorDocument":documentField,
        "doctorDocumentType":documentType,
        "doctorPhoneNumber":phoneNumber,
    }

    let request = sendRequest('doctor/',id ? 'PUT':'POST', data)

    request.onload = function(){
        window.location = '../doctors/index.html';
    }

    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}