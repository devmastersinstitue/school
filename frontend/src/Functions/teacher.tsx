function Teacher(props: any) {
  return (
    <div className="w-80 bg-gradient-to-br from-blue-50 to-purple-100 shadow-xl rounded-2xl p-6 border border-gray-200 hover:scale-105 transition-transform duration-300">
      
      <div className="text-center mb-4">
        <h2 className="text-2xl font-bold text-red-600">
          {props.name}
        </h2>
        <p className="text-blue-700 font-semibold">
          {props.subject} Teacher
        </p>
      </div>

      <hr className="mb-4 border-gray-300" />

      <div className="space-y-2 text-gray-700">
        <p>
          <span className="font-semibold text-green-700">Experience:</span>{" "}
          {props.experience} Years
        </p>

        <p>
          <span className="font-semibold text-purple-700">Email:</span>{" "}
          {props.email}
        </p>

        <p>
          <span className="font-semibold text-orange-700">Phone:</span>{" "}
          {props.phone}
        </p>
      </div>

      <hr className="my-4 border-gray-300" />

      <div className="text-center">
        <button className="bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700 transition">
          Contact Teacher
        </button>
      </div>

    </div>
  );
}

export default Teacher;