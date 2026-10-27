
const form = document.querySelector("#contactForm");
const status = document.querySelector("#status");

form.addEventListener("submit", async function (event) {
  event.preventDefault();

  const datos = {
    name: document.querySelector("#name").value,
    email: document.querySelector("#email").value,
    message: document.querySelector("#message").value
  };

  try {
    const respuesta = await fetch(
      "https://jsonplaceholder.typicode.com/posts",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(datos)
      }
    );

    if (!respuesta.ok) {
      throw new Error("Error al enviar");
    }

    const resultado = await respuesta.json();

    status.textContent =
      "¡Mensaje enviado! ID: " + resultado.id;

    status.className = "status success";
    form.reset();

  } catch (error) {
    status.textContent = "Error al conectar con la API.";
    status.className = "status error";
  }
});
