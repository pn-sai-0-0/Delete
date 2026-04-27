// REGISTER
async function register() {
  let res = await fetch('/api/register', {
    method: 'POST',
    headers: {'Content-Type':'application/json'},
    body: JSON.stringify({
      name: name.value,
      email: email.value,
      password: pass.value
    })
  });

  alert(await res.text());
  window.location.href = "login.html";
}

// LOGIN
async function login() {
  let res = await fetch('/api/login', {
    method: 'POST',
    headers: {'Content-Type':'application/json'},
    body: JSON.stringify({
      email: lemail.value,
      password: lpass.value
    })
  });

  let msg = await res.text();
  alert(msg);

  if (msg === "Login Success") {
    window.location.href = "home.html";
  }
}

// BOOK
async function book() {
  let res = await fetch('/api/book', {
    method: 'POST',
    headers: {'Content-Type':'application/json'},
    body: JSON.stringify({
      doctorName: doc.value,
      date: date.value,
      time: time.value
    })
  });

  alert(await res.text());
}

// LOAD
async function load() {
  let res = await fetch('/api/appointments');
  let data = await res.json();

  list.innerHTML = "";

  data.forEach(a => {
    let li = document.createElement("li");
    li.innerHTML = a.doctorName + " " + a.date + " " + a.time;
    list.appendChild(li);
  });
}