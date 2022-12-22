
export default function SecondaryBtn({text, clickFn}){
  return (
    <button onClick={clickFn}> {text} </button>
  )
}