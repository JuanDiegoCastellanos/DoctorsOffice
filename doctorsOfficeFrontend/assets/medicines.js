function loadData(){
    let request = sendRequest('medicine/list', 'GET', '');
    let table = document.getElementById('medicinesTable');
    table.innerHTML = "";
    request.onload = function(){

        let data = request.response;
        data.forEach((element,index) => {
            table.innerHTML += `
            <tr>
                <td class='text-center'>${element.medicineName}</td>
                <td class='text-center'>${element.laboratory}</td>
                <td class='text-center'>
                    <a href="../medicines/create.html?id=${element.medicineId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deleteMedicine(${element.medicineId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
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
function loadMedicineByName(){

    let request = sendRequest('medicine/list', 'GET', '');
    let divTable = document.getElementById('spaceTable');
    let name = document.getElementById('inputName').value;
    let data;
    request.onload = function () {
        if(name == ''){
            alert('Por favor llena el campo de búsqueda')
        }else{
            data = request.response;
            let medicine;
            for (let index = 0; index < data.length; index++) {
                const element = data[index];
                if(element.medicineName.trim().toUpperCase() == name.trim().toUpperCase()){
                    medicine = element;
                }
            }
            if(medicine != undefined || medicine != null){
            divTable.innerHTML = `
         <table class="table table-dark table-hover table-sm">
            <thead>
                <tr>
                    <th class="text-center" >Medicine Name</th>
                    <th class="text-center" >Laboratory</th>
                    <th class="text-center" ></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="" >${medicine.medicineName}</td>
                    <td class="text-center">${medicine.laboratory}</td>
                    <td class="text-center">
                    <a href="../medicines/create.html?id=${medicine.medicineId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deleteMedicine(${medicine.medicineId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
                    </td>
                 </tr>                    
            </tbody>
         </table>
         `;
            }else{
                alert("Este medicamento no existe");
            }
        }
        
    } 
}

function loadMedicine(idMedicine) {
    let request = sendRequest('medicine/list/'+idMedicine, 'GET', '');
    let id = document.getElementById('inputId');
    let name = document.getElementById('inputName');
    let laboratory = document.getElementById('inputLaboratory');
    
    request.onload = function () {
        let data = request.response;
        id.value = data.medicineId;
        name.value = data.medicineName;
        laboratory.value = data.laboratory;
    }
    request.onerror = function(){
        alert("Error al recuperar los datos");
    }
}

function deleteMedicine(idMedicine){
    let request =  sendRequest('medicine/'+idMedicine, 'DELETE','');
    request.onload = function () {
        loadData();
    }
}

function saveMedicine(){
    
    let name = document.getElementById('inputName').value
    let laboratory = document.getElementById('inputLaboratory').value

    let data = {
        "medicineName":name,
        "laboratory":laboratory
    }
    
    let request = sendRequest('medicine/','POST', data)

    request.onload = function(){
        window.location = '../medicines/index.html';
    }
    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}

function editMedicine() {
    let id = document.getElementById('inputId').value
    let name = document.getElementById('inputName').value
    let laboratory = document.getElementById('inputLaboratory').value

    let data = {
        "medicineId":id,
        "medicineName":name,
        "laboratory":laboratory,
    }

    let request = sendRequest('medicine/',id ? 'PUT':'POST', data)

    request.onload = function(){
        window.location = '../medicines/index.html';
    }

    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}