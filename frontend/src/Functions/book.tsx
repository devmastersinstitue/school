function Book(props: any) {
  return (
    <div>
      <h2>Book Title: {props.title}</h2>
      <p>Author: {props.author}</p>
    </div>
  );
}

export default Book;