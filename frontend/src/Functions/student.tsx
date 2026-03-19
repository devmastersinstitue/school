function Student(props : any) {
  return (
    <div>
      <h2>Name: {props.name}</h2>
      <p>Grade: {props.grade}</p>
    </div>
  );
}

export default Student;