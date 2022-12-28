import './EventCard.css'

export default function EventCard({price, dateTime, btnText}){
  return(
    <article class="event-card">
      <div class="EventCard-inner-card">
        <div class="EventCard-header-container">
        <h3>
          {price}
          </h3>
        </div>
        <div class="EventCard-text-container">
          <p>
            {dateTime}
            </p> 
        </div>
        <div class="EventCard-btn-container">
          <button> 
            {btnText} 
          </button>
        </div>
      </div>
    </article>
  )
}