import './AddCarForm.css'
import FormLayout from "Layouts/FormLayout/FormLayout";
import FormInput from "Components/forms/FormInput/FormInput";
import { useState } from "react";
import SharkParkLogo from "Components/SharkParkLogo/SharkParkLogo";

export default function AddCarForm({changeForm}){
  const [formData, setFormData] = useState({
    licensePlateNr: "",
    model: "",
  });

  function setLicensePlate(data){
    setFormData(prev => {
      return {...prev, licensePlateNr: data}
    })  
  }

  function setModel(data){
    setFormData(prev => {
      return {...prev, model: data}
    })  
  }

  return (
    <div id="add-car-form">
      <div id="shark-park-logo">
        <SharkParkLogo />
      </div>
      <FormLayout redirectFn={changeForm} btnText="create car">
        <FormInput inputId="licensePlateNr-input" pHolderText="Enter License plate nr..." getInputValue={setLicensePlate} />
        <FormInput inputId="model-input" pHolderText="Enter car model..." getInputValue={setModel} />
      </FormLayout>
    </div>
  )
}