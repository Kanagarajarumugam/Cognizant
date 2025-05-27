/* ========== 1. JavaScript Basics & Setup ========== */
console.log("Welcome to the Community Portal");
window.onload = function () {
  alert("Page is fully loaded!");
};

/* ========== 2. Syntax, Data Types, and Operators ========== */
const eventName = "Community Music Night";
const eventDate = "2025-06-15";
let availableSeats = 50;
console.log(`Event: ${eventName} on ${eventDate} - Seats: ${availableSeats}`);

/* ========== 3. Conditionals, Loops, and Error Handling ========== */
const events = [
  { name: "Art Fair", date: "2025-07-10", seats: 5 },
  { name: "Tech Workshop", date: "2023-05-20", seats: 0 },
  { name: "Music Night", date: "2025-06-15", seats: 10 },
];

events.forEach(e => {
  if (new Date(e.date) > new Date() && e.seats > 0) {
    console.log(`Upcoming Event: ${e.name}`);
  }
});

function register(event) {
  try {
    if (event.seats <= 0) throw "No seats available";
    event.seats--;
    console.log(`Registered for ${event.name}, Remaining: ${event.seats}`);
  } catch (err) {
    console.error(err);
  }
}

/* ========== 4. Functions and Closures ========== */
function addEvent(name, category) {
  events.push({ name, category });
}

function registerUser(eventName) {
  const event = events.find(e => e.name === eventName);
  if (event) register(event);
}

function filterEventsByCategory(category) {
  return events.filter(e => e.category === category);
}

function categoryCounter() {
  let count = 0;
  return function () {
    count++;
    return count;
  };
}

/* ========== 5. Objects and Prototypes ========== */
function Event(name, seats) {
  this.name = name;
  this.seats = seats;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const myEvent = new Event("Local Meetup", 20);
console.log(Object.entries(myEvent));

/* ========== 6. Arrays and Methods ========== */
const eventList = [];
eventList.push({ name: "Yoga Class", type: "Health" });
const musicEvents = eventList.filter(e => e.type === "Music");
const eventTitles = eventList.map(e => `Event: ${e.name}`);

/* ========== 7. DOM Manipulation ========== */
const container = document.querySelector("#eventContainer");

function renderEventCard(event) {
  const card = document.createElement("div");
  card.className = "eventCard";
  card.textContent = event.name;
  container.appendChild(card);
}

/* ========== 8. Event Handling ========== */
document.querySelectorAll(".registerBtn").forEach(btn => {
  btn.onclick = () => alert("You registered!");
});
document.querySelector("#categoryFilter").onchange = e => {
  console.log("Filtered by:", e.target.value);
};
document.querySelector("#eventSearch").onkeydown = e => {
  console.log("Key pressed:", e.key);
};

/* ========== 9. Async JS ========== */
function fetchEvents() {
  document.getElementById("loading").style.display = "block";
  fetch("https://example.com/events.json")
    .then(res => res.json())
    .then(data => console.log(data))
    .catch(err => console.error(err))
    .finally(() => {
      document.getElementById("loading").style.display = "none";
    });
}

async function fetchAsyncEvents() {
  try {
    const res = await fetch("https://example.com/events.json");
    const data = await res.json();
    console.log(data);
  } catch (err) {
    console.error(err);
  }
}

/* ========== 10. Modern JS Features ========== */
const showDetails = ({ name, seats }) => {
  console.log(`Event: ${name} - Seats: ${seats}`);
};

const defaultEvent = (type = "Workshop") => {
  console.log("Default event type is", type);
};

const newList = [...eventList];

/* ========== 11. Working with Forms ========== */
document.querySelector("#eventForm").onsubmit = function (e) {
  e.preventDefault();
  const name = this.elements["username"].value;
  const email = this.elements["email"].value;
  if (!name || !email) {
    document.querySelector("#formError").textContent = "Fill all fields";
  } else {
    console.log("Registered:", name, email);
  }
};

/* ========== 12. AJAX & Fetch API ========== */
function submitRegistration(data) {
  fetch("https://example.com/register", {
    method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" }
  })
    .then(res => res.json())
    .then(() => alert("Registration successful!"))
    .catch(() => alert("Failed!"))
    .finally(() => setTimeout(() => console.log("Response complete"), 2000));
}

/* ========== 13. Debugging and Testing ========== */
// Use console.log, debugger, and inspect form fields
function debugFormSubmission() {
  const form = document.querySelector("#eventForm");
  form.onsubmit = e => {
    e.preventDefault();
    console.log("Submitting form");
    debugger;
    // Inspect form values
  };
}

/* ========== 14. jQuery and JS Frameworks ========== */
// Requires jQuery to be included
$(document).ready(function () {
  $("#registerBtn").click(function () {
    alert("Registered via jQuery!");
  });
  $(".eventCard").fadeIn(1000);
  console.log("React/Vue helps in scalable app structure");
});
