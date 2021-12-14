const value = localStorage.getItem("theme");
const html = document.querySelector("html");
const darkModeFile = document.getElementById("dark");
const lightModeFile = document.getElementById("dark2");
if (value.includes("dark")){
    lightModeFile.remove();
}else {
    darkModeFile.remove();
}