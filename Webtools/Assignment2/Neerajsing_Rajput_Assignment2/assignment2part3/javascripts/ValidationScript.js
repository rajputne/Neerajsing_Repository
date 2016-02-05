
        function create() {
            var param = document.getElementById("txtNumb").value;
            var s = "";
            if (isNaN(param) || param > 1 || param < 100) {
                for (var i = 0; i < param; i++) {
                    s += 'Enter your children ' + (i + 1) + ' name here:<input type="text" name="name" required maxlength="30"><br/>';
                    document.getElementById("screens").innerHTML = s;
                }
				   s += '<button type="submit" name="action" value="Submit">Submit Children Names</button>';
                document.getElementById("screens").innerHTML = s;

            } else {
                s = "Input not OK";
                document.getElementById("screens").innerHTML = s;
            }   
        }
