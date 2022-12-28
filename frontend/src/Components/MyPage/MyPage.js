import SecondaryBtn from "Components/btns/SecondaryBtn";
import EventCard from "Components/EventCard/EventCard";
import AddCarForm from "Components/forms/AddCarForm/AddCarForm";
import StartEventForm from "Components/forms/StartEventForm/StartEventForm"
import MyParkingEvents from "Components/MyParkingEvents/MyParkingEvents";
import VerticalMenuLayout from "Layouts/VerticalMenuLayout/VerticalMenuLayout";
import { useState } from "react"
import "./MyPage.css"

export default function MyPage ({userName}) {
  const [child, setChild] = useState();

  function getAddCarForm(){
    setChild(<AddCarForm/>)
  }

  function getMyParkingCard(){
    setChild(
      <MyParkingEvents ChangeForm={setChild}>
         <EventCard btnText="pay" price="30" dateTime="2022/02/12 11:40-12:23" />
         <EventCard btnText="pay" price="30" dateTime="2022/02/12 11:40-12:23" />
         <EventCard btnText="pay" price="30" dateTime="2022/02/12 11:40-12:23" />
      </MyParkingEvents>
    )
  }

  function getStartParkingForm(){
    setChild(<StartEventForm />)
  }
  return (
    <section id="my-page">
      <VerticalMenuLayout userName={userName}> 
        <SecondaryBtn text="start parking" clickFn={getStartParkingForm}/>
        <SecondaryBtn text="my parkings" clickFn={getMyParkingCard}/>
        <SecondaryBtn text="add car" clickFn={getAddCarForm} />
      </VerticalMenuLayout>
      <div id="my-page-body">
        <div class="form-container">
          {child}
        </div>
      </div>
    </section>
  )
}