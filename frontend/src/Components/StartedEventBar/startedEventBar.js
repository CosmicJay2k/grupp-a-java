import { useEffect, useState } from "react"
import './StartedEventBar.css'
export default function StartedEventBar() {

  const [ms, setMs] = useState(0); 

  useEffect(() => {
    let interval;
    interval = setInterval(() => {
      setMs(prev => prev + 10)
    }, 10)
  }, [])

  return (
    <div id="started-event-bar">
      <p>ongoing event:  {
        ("0" + Math.floor((ms / 6000000) % 60)).slice(-2)}
        :
        {("0" + Math.floor((ms / 600000) % 60)).slice(-2)}
        :
        {("0" + Math.floor((ms / 1000) % 60)).slice(-2)}</p>
      <button>
        stop
      </button>
    </div>
  )
}