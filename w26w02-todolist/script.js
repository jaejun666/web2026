const form = document.getElementById('todo-form');
const input = document.getElementById('todo-input');
const list = document.getElementById('todo-list');

// 1. 저장된 할 일 불러오기
let todos = JSON.parse(localStorage.getItem('todos')) || [];

function saveTodos() {
  localStorage.setItem('todos', JSON.stringify(todos));
}

function renderTodos() {
  list.innerHTML = '';
  todos.forEach((todo, index) => {
    const li = document.createElement('li');
    if (todo.completed) li.classList.add('completed');

    li.innerHTML = `
      <span onclick="toggleTodo(${index})">${todo.text}</span>
      <button class="delete-btn" onclick="deleteTodo(${index})">삭제</button>
    `;
    list.appendChild(li);
  });
}

// 2. 할 일 추가
form.addEventListener('submit', (e) => {
  e.preventDefault();
  const text = input.value.trim();
  if (text) {
    todos.push({ text, completed: false });
    input.value = '';
    saveTodos();
    renderTodos();
  }
});

// 3. 완료 토글
window.toggleTodo = (index) => {
  todos[index].completed = !todos[index].completed;
  saveTodos();
  renderTodos();
};

// 4. 할 일 삭제
window.deleteTodo = (index) => {
  todos.splice(index, 1);
  saveTodos();
  renderTodos();
};

// 초기 실행
renderTodos();