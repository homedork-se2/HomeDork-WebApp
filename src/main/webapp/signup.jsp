
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Signup HomeDork</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&display=swap" rel="stylesheet">
    <style>
        .body-bg {
            background: rgb(182,93,24);
            background: radial-gradient(circle, rgba(182,93,24,0.9079832616640406) 50%, rgba(233,215,148,0.725910432532388) 100%);
        }
    </style>
</head>
<body class="body-bg min-h-screen pt-12 md:pt-20 pb-6 px-2 md:px-0" style="font-family:'Lato',sans-serif;">
<header class="max-w-lg mx-auto">
    <a href="#">
        <h1 class="text-4xl font-bold text-white text-center">Sign up</h1>
    </a>
</header>

<main class="bg-white max-w-lg mx-auto p-8 md:p-12 my-10 rounded-lg shadow-2xl">
    <section>
        <h3 class="font-bold text-2xl">HomeDork</h3>
        <p class="text-gray-600 pt-2">Sign Up</p>
    </section>

    <section class="mt-4">
        <form class="flex flex-col" method="POST" action="/SignupServlet">
            <div class="mb-2 pt-3 rounded">
                <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="email">Email</label>
                <input type="email" class="block w-96 border border-gray-400 rounded-full py-3 px-6 block mb-1" name="email" id="email" placeholder="email..." required>
            </div>
            <div class="mb-2 pt-3 rounded ">
                <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="Username">Username</label>
                <input type="text" class="block w-96 border border-gray-400 rounded-full py-3 px-6 block mb-1" name="username" id="username" placeholder="username..." required>
            </div>
            <div class="mb-8 pt-3 rounded ">
                <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="password">Password</label>
                <input type="password" class="block w-96 border border-gray-400 rounded-full py-3 px-6 block mb-1" name="password" id="password" placeholder="password..." required>
            </div>

            <button type="submit" class="block w-96 border border-gray-400 rounded-full py-3 px-6 bg-yellow-500 hover:bg-yellow-400">Sign Up</button>
        </form>
    </section>
</main>


<footer class="max-w-lg mx-auto flex justify-center text-white">
    <span class="mx-3">•</span>
    <a href="#" class="hover:underline">Contact</a>

</footer>
</body>
</html>
