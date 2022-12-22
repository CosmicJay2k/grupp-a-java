import { useState } from "react";
import LoginForm from "Components/LoginForm/LoginForm";
import RegisterForm from "Components/RegisterForm/RegisterForm";
import PrimaryCardLayout from "Layouts/PrimaryCardLayout/PrimaryCardLayout";
import 'style/App.css'
import PrimaryHeader from "Components/Headers/PrimaryHeader";
import SecondaryHeader from "Components/Headers/SecondaryHeader"

function App() {
  const [switchForm, setSwitchForm] = useState(true)

  function handleChangeForm(){
    setSwitchForm(prev => !prev)
  }

  return (
    <div className="App">
      { switchForm ? <PrimaryHeader text='login'/> : <SecondaryHeader text='register' /> }
      <PrimaryCardLayout>
        {
          switchForm ? <LoginForm changeForm={handleChangeForm}  /> : <RegisterForm changeForm={handleChangeForm}/>  
        }
      </PrimaryCardLayout>
    </div>
  );
}

export default App;
