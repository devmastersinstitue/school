import './../index.css'
function Class(props: any) {
  return (
    <div className="w-[340px] rounded-2xl border border-orange-200 bg-white/95 p-5 text-gray-900 shadow-xl">

      <div className="text-center mb-3">
        <h2 className="text-2xl font-bold text-red-600">
          Class Profile
        </h2>
      </div>

      <hr className="mb-3 border-0 border-t border-orange-300" />

      <div className="space-y-3 text-gray-800">

        <p className="bg-yellow-200 p-2 rounded-lg">
          <span className="font-semibold text-yellow-800">Class Name:</span>{" "}
          {props.className}
        </p>

        <p className="bg-red-200 p-2 rounded-lg">
          <span className="font-semibold text-red-800">Total Students:</span>{" "}
          {props.totalStudents}
        </p>

      </div>

  <hr className="my-4 border-0 border-t border-orange-300" />

   
      <div className="text-center">
        <button className="bg-orange-600 text-white px-4 py-2 rounded-lg hover:bg-orange-700 transition">
          View Class
        </button>
      </div>

    </div>
  );
}

export default Class;