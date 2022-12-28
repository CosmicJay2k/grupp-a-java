import './MyParkingEvents.css'
import { useState } from "react";
import SharkParkLogo from "Components/SharkParkLogo/SharkParkLogo";
import PrimaryBtn from 'Components/btns/PrimaryBtn';
import StartEventForm from 'Components/forms/StartEventForm/StartEventForm';

export default function MyParkingEvents({ ChangeForm, children }){

  return (
    <div id="my-parking-event-container">
      <div id="shark-park-logo">
        <SharkParkLogo />
      </div>
      <div id="card-container">
        {children}
      </div>
      <div>
        <PrimaryBtn text="create event" clickFn={
          () => ChangeForm(<StartEventForm />)
        }/>
      </div>
    </div>
  )
}