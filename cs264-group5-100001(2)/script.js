
function addRow(tableId) {
    const table = document.getElementById(tableId);

    // Check if the table already has 10 rows
    if (table.rows.length >= 11) {
        alert('You cannot add more than 10 rows.');
        return;
    }

    const newRow = table.insertRow();
    for (let i = 0; i < 7; i++) {
        const cell = newRow.insertCell(i);
        const input = document.createElement('input');
        switch (i) {
            case 2:
                input.type = 'number';
                break;
            case 4:
                input.type = 'number';
                break;
            case 6:
                input.type = 'checkbox';
                break;
            default:
                input.type = 'text';
        }

        input.name = `${tableId}[${table.rows.length}][${i}]`;
        cell.appendChild(input);
    }
}


function removeLastRow(tableId) {
	const table = document.getElementById(tableId);
	if (table.rows.length > 1) {
		table.deleteRow(table.rows.length - 1);
	}
}

function submitForm() {
event.preventDefault();
console.log(addSubjectList.rows[1].cells[0].querySelector('input').value);
  const formData = new FormData(document.getElementById('userForm'))
  const user = {
  				date: formData.get('Date'),
                nameTitles: formData.get('nameTitles'),
                studentFirstName: formData.get('studentFirstName'),
                studentLastName: formData.get('studentLastName'),
                studentId: formData.get('studentId'),
                studentYear: formData.get('studentYear'),
                studyField: formData.get('studyField'),
                advisor: formData.get('advisor'),
                addressNumber: formData.get('addressNumber'),
                moo: formData.get('moo'),
                tumbol: formData.get('tumbol'),
                amphur: formData.get('amphur'),
                Province: formData.get('Province'),
                postalCode: formData.get('postalCode'),
                mobilePhone: formData.get('mobilePhone'),
                phone: formData.get('phone'),
                cause: formData.get('cause'),

                addsubject1Code : addSubjectList.rows[1].cells[0].querySelector('input').value,
                                addsubject1Name : addSubjectList.rows[1].cells[1].querySelector('input').value,
                                addsubject1Section : addSubjectList.rows[1].cells[2].querySelector('input').value,
                                addsubject1Date : addSubjectList.rows[1].cells[3].querySelector('input').value,
                                addsubject1Credit : addSubjectList.rows[1].cells[4].querySelector('input').value,
                                addsubject1Teacher : addSubjectList.rows[1].cells[5].querySelector('input').value,
                                addsubject1TeacherCheck : addSubjectList.rows[1].cells[6].querySelector('input').checked,

                                addsubject2Code : addSubjectList.rows[2].cells[0].querySelector('input').value,
                                addsubject2Name : addSubjectList.rows[2].cells[1].querySelector('input').value,
                                addsubject2Section : addSubjectList.rows[2].cells[2].querySelector('input').value,
                                addsubject2Date : addSubjectList.rows[2].cells[3].querySelector('input').value,
                                addsubject2Credit : addSubjectList.rows[2].cells[4].querySelector('input').value,
                                addsubject2Teacher : addSubjectList.rows[2].cells[5].querySelector('input').value,
                                addsubject2TeacherCheck : addSubjectList.rows[2].cells[6].querySelector('input').checked,

                                addsubject3Code : addSubjectList.rows[3].cells[0].querySelector('input').value,
                                addsubject3Name : addSubjectList.rows[3].cells[1].querySelector('input').value,
                                addsubject3Section : addSubjectList.rows[3].cells[2].querySelector('input').value,
                                addsubject3Date : addSubjectList.rows[3].cells[3].querySelector('input').value,
                                addsubject3Credit : addSubjectList.rows[3].cells[4].querySelector('input').value,
                                addsubject3Teacher : addSubjectList.rows[3].cells[5].querySelector('input').value,
                                addsubject3TeacherCheck : addSubjectList.rows[3].cells[6].querySelector('input').checked,

                                addsubject4Code : addSubjectList.rows[4].cells[0].querySelector('input').value,
                                addsubject4Name : addSubjectList.rows[4].cells[1].querySelector('input').value,
                                addsubject4Section : addSubjectList.rows[4].cells[2].querySelector('input').value,
                                addsubject4Date : addSubjectList.rows[4].cells[3].querySelector('input').value,
                                addsubject4Credit : addSubjectList.rows[4].cells[4].querySelector('input').value,
                                addsubject4Teacher : addSubjectList.rows[4].cells[5].querySelector('input').value,
                                addsubject4TeacherCheck : addSubjectList.rows[4].cells[6].querySelector('input').checked,

                                addsubject5Code : addSubjectList.rows[5].cells[0].querySelector('input').value,
                                addsubject5Name : addSubjectList.rows[5].cells[1].querySelector('input').value,
                                addsubject5Section : addSubjectList.rows[5].cells[2].querySelector('input').value,
                                addsubject5Date : addSubjectList.rows[5].cells[3].querySelector('input').value,
                                addsubject5Credit : addSubjectList.rows[5].cells[4].querySelector('input').value,
                                addsubject5Teacher : addSubjectList.rows[5].cells[5].querySelector('input').value,
                                addsubject5TeacherCheck : addSubjectList.rows[5].cells[6].querySelector('input').checked,

                                addsubject6Code : addSubjectList.rows[6].cells[0].querySelector('input').value,
                                addsubject6Name : addSubjectList.rows[6].cells[1].querySelector('input').value,
                                addsubject6Section : addSubjectList.rows[6].cells[2].querySelector('input').value,
                                addsubject6Date : addSubjectList.rows[6].cells[3].querySelector('input').value,
                                addsubject6Credit : addSubjectList.rows[6].cells[4].querySelector('input').value,
                                addsubject6Teacher : addSubjectList.rows[6].cells[5].querySelector('input').value,
                                addsubject6TeacherCheck : addSubjectList.rows[6].cells[6].querySelector('input').checked,

                                addsubject7Code : addSubjectList.rows[7].cells[0].querySelector('input').value,
                                addsubject7Name : addSubjectList.rows[7].cells[1].querySelector('input').value,
                                addsubject7Section : addSubjectList.rows[7].cells[2].querySelector('input').value,
                                addsubject7Date : addSubjectList.rows[7].cells[3].querySelector('input').value,
                                addsubject7Credit : addSubjectList.rows[7].cells[4].querySelector('input').value,
                                addsubject7Teacher : addSubjectList.rows[7].cells[5].querySelector('input').value,
                                addsubject7TeacherCheck : addSubjectList.rows[7].cells[6].querySelector('input').checked,

                                addsubject8Code : addSubjectList.rows[8].cells[0].querySelector('input').value,
                                addsubject8Name : addSubjectList.rows[8].cells[1].querySelector('input').value,
                                addsubject8Section : addSubjectList.rows[8].cells[2].querySelector('input').value,
                                addsubject8Date : addSubjectList.rows[8].cells[3].querySelector('input').value,
                                addsubject8Credit : addSubjectList.rows[8].cells[4].querySelector('input').value,
                                addsubject8Teacher : addSubjectList.rows[8].cells[5].querySelector('input').value,
                                addsubject8TeacherCheck : addSubjectList.rows[8].cells[6].querySelector('input').checked,

                                addsubject9Code : addSubjectList.rows[9].cells[0].querySelector('input').value,
                                addsubject9Name : addSubjectList.rows[9].cells[1].querySelector('input').value,
                                addsubject9Section : addSubjectList.rows[9].cells[2].querySelector('input').value,
                                addsubject9Date : addSubjectList.rows[9].cells[3].querySelector('input').value,
                                addsubject9Credit : addSubjectList.rows[9].cells[4].querySelector('input').value,
                                addsubject9Teacher : addSubjectList.rows[9].cells[5].querySelector('input').value,
                                addsubject9TeacherCheck : addSubjectList.rows[9].cells[6].querySelector('input').checked,

                                addsubject10Code : addSubjectList.rows[10].cells[0].querySelector('input').value,
                                addsubject10Name : addSubjectList.rows[10].cells[1].querySelector('input').value,
                                addsubject10Section : addSubjectList.rows[10].cells[2].querySelector('input').value,
                                addsubject10Date : addSubjectList.rows[10].cells[3].querySelector('input').value,
                                addsubject10Credit : addSubjectList.rows[10].cells[4].querySelector('input').value,
                                addsubject10Teacher : addSubjectList.rows[10].cells[5].querySelector('input').value,
                                addsubject10TeacherCheck : addSubjectList.rows[10].cells[6].querySelector('input').checked,

                                dropsubject1Code : dropSubjectList.rows[1].cells[0].querySelector('input').value,
                                dropsubject1Name : dropSubjectList.rows[1].cells[1].querySelector('input').value,
                                dropsubject1Section : dropSubjectList.rows[1].cells[2].querySelector('input').value,
                                dropsubject1Date : dropSubjectList.rows[1].cells[3].querySelector('input').value,
                                dropsubject1Credit : dropSubjectList.rows[1].cells[4].querySelector('input').value,
                                dropsubject1Teacher : dropSubjectList.rows[1].cells[5].querySelector('input').value,
                                dropsubject1TeacherCheck : dropSubjectList.rows[1].cells[6].querySelector('input').checked,

                                dropsubject2Code : dropSubjectList.rows[2].cells[0].querySelector('input').value,
                                dropsubject2Name : dropSubjectList.rows[2].cells[1].querySelector('input').value,
                                dropsubject2Section : dropSubjectList.rows[2].cells[2].querySelector('input').value,
                                dropsubject2Date : dropSubjectList.rows[2].cells[3].querySelector('input').value,
                                dropsubject2Credit : dropSubjectList.rows[2].cells[4].querySelector('input').value,
                                dropsubject2Teacher : dropSubjectList.rows[2].cells[5].querySelector('input').value,
                                dropsubject2TeacherCheck : dropSubjectList.rows[2].cells[6].querySelector('input').checked,

                                dropsubject3Code : dropSubjectList.rows[3].cells[0].querySelector('input').value,
                                dropsubject3Name : dropSubjectList.rows[3].cells[1].querySelector('input').value,
                                dropsubject3Section : dropSubjectList.rows[3].cells[2].querySelector('input').value,
                                dropsubject3Date : dropSubjectList.rows[3].cells[3].querySelector('input').value,
                                dropsubject3Credit : dropSubjectList.rows[3].cells[4].querySelector('input').value,
                                dropsubject3Teacher : dropSubjectList.rows[3].cells[5].querySelector('input').value,
                                dropsubject3TeacherCheck : dropSubjectList.rows[3].cells[6].querySelector('input').checked,

                                dropsubject4Code : dropSubjectList.rows[4].cells[0].querySelector('input').value,
                                dropsubject4Name : dropSubjectList.rows[4].cells[1].querySelector('input').value,
                                dropsubject4Section : dropSubjectList.rows[4].cells[2].querySelector('input').value,
                                dropsubject4Date : dropSubjectList.rows[4].cells[3].querySelector('input').value,
                                dropsubject4Credit : dropSubjectList.rows[4].cells[4].querySelector('input').value,
                                dropsubject4Teacher : dropSubjectList.rows[4].cells[5].querySelector('input').value,
                                dropsubject4TeacherCheck : dropSubjectList.rows[4].cells[6].querySelector('input').checked,

                                dropsubject5Code : dropSubjectList.rows[5].cells[0].querySelector('input').value,
                                dropsubject5Name : dropSubjectList.rows[5].cells[1].querySelector('input').value,
                                dropsubject5Section : dropSubjectList.rows[5].cells[2].querySelector('input').value,
                                dropsubject5Date : dropSubjectList.rows[5].cells[3].querySelector('input').value,
                                dropsubject5Credit : dropSubjectList.rows[5].cells[4].querySelector('input').value,
                                dropsubject5Teacher : dropSubjectList.rows[5].cells[5].querySelector('input').value,
                                dropsubject5TeacherCheck : dropSubjectList.rows[5].cells[6].querySelector('input').checked,

                                dropsubject6Code : dropSubjectList.rows[6].cells[0].querySelector('input').value,
                                dropsubject6Name : dropSubjectList.rows[6].cells[1].querySelector('input').value,
                                dropsubject6Section : dropSubjectList.rows[6].cells[2].querySelector('input').value,
                                dropsubject6Date : dropSubjectList.rows[6].cells[3].querySelector('input').value,
                                dropsubject6Credit : dropSubjectList.rows[6].cells[4].querySelector('input').value,
                                dropsubject6Teacher : dropSubjectList.rows[6].cells[5].querySelector('input').value,
                                dropsubject6TeacherCheck : dropSubjectList.rows[6].cells[6].querySelector('input').checked,

                                dropsubject7Code : dropSubjectList.rows[7].cells[0].querySelector('input').value,
                                dropsubject7Name : dropSubjectList.rows[7].cells[1].querySelector('input').value,
                                dropsubject7Section : dropSubjectList.rows[7].cells[2].querySelector('input').value,
                                dropsubject7Date : dropSubjectList.rows[7].cells[3].querySelector('input').value,
                                dropsubject7Credit : dropSubjectList.rows[7].cells[4].querySelector('input').value,
                                dropsubject7Teacher : dropSubjectList.rows[7].cells[5].querySelector('input').value,
                                dropsubject7TeacherCheck : dropSubjectList.rows[7].cells[6].querySelector('input').checked,

                                dropsubject8Code : dropSubjectList.rows[8].cells[0].querySelector('input').value,
                                dropsubject86Name : dropSubjectList.rows[8].cells[1].querySelector('input').value,
                                dropsubject8Section : dropSubjectList.rows[8].cells[2].querySelector('input').value,
                                dropsubject8Date : dropSubjectList.rows[8].cells[3].querySelector('input').value,
                                dropsubject8Credit : dropSubjectList.rows[8].cells[4].querySelector('input').value,
                                dropsubject8Teacher : dropSubjectList.rows[8].cells[5].querySelector('input').value,
                                dropsubject8TeacherCheck : dropSubjectList.rows[8].cells[6].querySelector('input').checked,

                                dropsubject9Code : dropSubjectList.rows[9].cells[0].querySelector('input').value,
                                dropsubject9Name : dropSubjectList.rows[9].cells[1].querySelector('input').value,
                                dropsubject9Section : dropSubjectList.rows[9].cells[2].querySelector('input').value,
                                dropsubject9Date : dropSubjectList.rows[9].cells[3].querySelector('input').value,
                                dropsubject9Credit : dropSubjectList.rows[9].cells[4].querySelector('input').value,
                                dropsubject9Teacher : dropSubjectList.rows[9].cells[5].querySelector('input').value,
                                dropsubject9TeacherCheck : dropSubjectList.rows[9].cells[6].querySelector('input').checked,

                                dropsubject10Code : dropSubjectList.rows[10].cells[0].querySelector('input').value,
                                dropsubject10Name : dropSubjectList.rows[10].cells[1].querySelector('input').value,
                                dropsubject10Section : dropSubjectList.rows[10].cells[2].querySelector('input').value,
                                dropsubject10Date : dropSubjectList.rows[10].cells[3].querySelector('input').value,
                                dropsubject10Credit : dropSubjectList.rows[10].cells[4].querySelector('input').value,
                                dropsubject10Teacher : dropSubjectList.rows[10].cells[5].querySelector('input').value,
                                dropsubject10TeacherCheck : dropSubjectList.rows[10].cells[6].querySelector('input').checked
            };
            console.log(formData.get('studentFirstName'));
        fetch('/form', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            })
            .then(response => {
                if (response.ok) {
                    document.getElementById('result').innerText = 'User saved successfully.';
                    console.log("GOOD");
                } else {
                    /*response.text().then(errorMessage => {
                        document.getElementById('result').innerText = 'An error occurred while saving the user. Error message: ' + errorMessage;
                    });*/
                }
            })
            .catch(error => {
                //console.error('Error:', error);
                //document.getElementById('result').innerText = 'An error occurred while saving the user.';
            });
            console.log("wqer");
}

const userForm = document.getElementById('userForm');
userForm.addEventListener('submit', submitForm);
