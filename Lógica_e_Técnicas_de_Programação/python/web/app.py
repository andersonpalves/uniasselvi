from flask import Flask, render_template, request

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/resultado', methods=['POST'])
def resultado():
    nome = request.form['nome']
    return render_template('resultado.html', nome=nome)

if __name__ == '__main__':
    app.run(debug=True)