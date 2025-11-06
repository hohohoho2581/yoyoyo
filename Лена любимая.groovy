<!DOCTYPE html>
< lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Для [Имя]</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: #ffe6e6;
            font-family: 'Cursive', sans-serif;
            overflow: hidden;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .container {
            text-align: center;
            z-index: 100;
        }

        h1 {
            color: #ff4d6d;
            font-size: 4em;
            margin-bottom: 20px;
            text-shadow: 3px 3px 0px #fff;
        }

        .main-heart {
            font-size: 80px;
            color: #ff4d6d;
            animation: pulse 1.5s ease-in-out infinite both;
            cursor: pointer;
        }

        @keyframes pulse {
            0% { transform: scale(1); }
            50% { transform: scale(1.3); }
            100% { transform: scale(1); }
        }

        /* Стили для падающих сердечек */
        .hearts span {
            position: absolute;
            top: -50px;
            font-size: 20px;
            color: rgba(255, 77, 109, 0.7);
            animation: animate 5s linear infinite;
        }

        @keyframes animate {
            0% {
                transform: translateY(0) rotate(0deg);
                opacity: 1;
            }
            100% {
                transform: translateY(100vh) rotate(360deg);
                opacity: 0;
            }
        }
    </style>
</head>
<body>

    <div class="container">
        <!-- ЗАМЕНИ ИМЯ ЗДЕСЬ -->
        <h1>Лена</h1>
        <div class="main-heart">❤️</div>
    </div>

    <div class="hearts" id="heartsContainer"></div>

    <script>
        // Функция для создания падающих сердечек
        function createHeart() {
            const heart = document.createElement('span');
            heart.innerHTML = '❤️';
            heart.style.left = Math.random() * 100 + 'vw';
            heart.style.animationDuration = Math.random() * 3 + 2 + 's';
            document.getElementById('heartsContainer').appendChild(heart);

            // Удаляем сердечко после анимации, чтобы не засорять память
            setTimeout(() => {
                heart.remove();
            }, 5000);
        }

        // Создаем много сердечек
        setInterval(createHeart, 300);

        // Добавляем реакцию на клик по большому сердцу
        document.querySelector('.main-heart').addEventListener('click', function() {
            this.style.color = '#ff002b';
            setTimeout(() => {
                this.style.color = '#ff4d6d';
            }, 300);
        });
    </script>

</body>