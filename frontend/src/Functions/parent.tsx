function Parent(props: any) {
  return (
    <div className="w-72 bg-gradient-to-br from-green-100 via-blue-100 to-purple-100 shadow-xl rounded-2xl p-5 border border-green-200 hover:scale-105 transition-transform duration-300">
      
      {/* Header */}
      <div className="text-center mb-3">
        <h2 className="text-2xl font-bold text-green-700">
          Parent Profile
        </h2>
      </div>

      <hr className="mb-3 border-green-300" />

      {/* Parent Details */}
      <div className="space-y-3 text-gray-800">

        <p className="bg-blue-100 p-2 rounded-lg">
          <span className="font-semibold text-blue-700">Parent Name:</span>{" "}
          {props.name}
        </p>

        <p className="bg-purple-100 p-2 rounded-lg">
          <span className="font-semibold text-purple-700">Number of Children:</span>{" "}
          {props.childrenCount}
        </p>

      </div>

      <hr className="my-4 border-green-300" />

      {/* Footer */}
      <div className="text-center">
        <button className="bg-green-600 text-white px-4 py-2 rounded-lg hover:bg-green-700 transition">
          Contact Parent
        </button>
      </div>

    </div>
  );
}

export default Parent;