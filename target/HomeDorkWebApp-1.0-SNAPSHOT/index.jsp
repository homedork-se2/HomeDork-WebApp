<!doctype html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>

<div>
    <nav class="bg-gray-100 fixed right-0 left-0 z-10">
        <div class="max-w-6xl mx-auto px-4">
            <div class="flex justify-between">

                <div class="flex space-x-4">

                    <div>
                        <a href="#" class="flex items-center py-5 px-2 text-gray-700 hover:text-gray-900">
                            <img src="images/HomeDork@2x.png" width="150" height="75">
                        </a>
                    </div>


                    <div class="hidden md:flex items-center space-x-1">
                        <a href="#" class="py-5 px-3 text-gray-700 hover:text-yellow-600">Home</a>
                        <a href="#" class="py-5 px-3 text-gray-700 hover:text-gray-900">About Us</a>
                        <a href="#" class="py-5 px-3 text-gray-700 hover:text-gray-900">Contact</a>
                    </div>
                </div>

                <div class="hidden md:flex items-center space-x-1">
                    <a href="" class="py-2 px-3 bg-yellow-400 hover:bg-yellow-300 text-yellow-900 hover:text-yellow-800 rounded transition duration-300">Signup</a>
                </div>


                <div class="md:hidden flex items-center">
                    <button class="mobile-menu-button">
                        <svg class="w-6 h-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"></path>
                        </svg>
                    </button>
                </div>

            </div>
        </div>


        <div class="mobile-menu hidden md:hidden">
            <a href="#" class="block py-2 px-4 text-sm hover:bg-gray-200">Home</a>
            <a href="#" class="block py-2 px-4 text-sm hover:bg-gray-200">About Us</a>
            <a href="#" class="block py-2 px-4 text-sm hover:bg-gray-200">Contact</a>
        </div>


    </nav>

    <script src="mobile.js"></script>
    <form action="/LoginServlet" method="POST">
        <div class="flex flex-row">
            <div class="flex flex-col my-32 ml-56 w-100">
                <h2 class="font-extrabold text-4xl py-2">HomeDork the next generation <br> of Smart House.</h2>
                <h5 class="font-bold text-gray-500 text-base antialiased not-italic mb-12">HomeDork provides access to your smart house equipment,
                    <br> from lights, alarms, microwaves, TVs and many more. All in one single app.</h5>
                <input type="text" class="block w-96 border border-gray-400 rounded-full py-3 px-6 block mb-1" name="username" id="username" placeholder="username..." required>
                <input type="password" class="block w-96 border border-gray-400 rounded-full py-3 px-6 block mb-1" name="password" id="password" placeholder="password..." required>
                <span class="error">${messages}</span>
                <button type="submit" class="block w-96 border border-gray-400 rounded-full py-3 px-6 bg-yellow-500 hover:bg-yellow-400">login</button>
            </div>

            <div class="justify-between absolute right-0  mt-24 mr-48">
                <img src="images/Kad.png" alt="Image of a smart house" class="w-auto ml-56 mb-12 rounded-full shadow-xl">
            </div>
        </div>
    </form>
    <div class="m-auto mb-20">
        <img src="images/wavy.svg">
    </div>
</div>

</body>
</html>