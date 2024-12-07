using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BFS
{
    public enum Algorithm
    {
        BreathFirstSearch,
        BestFirstSearch
    }

    public partial class Form1 : Form
    {
        BreathFirstSearch _breathFS;
        BestFirstSearch _bestFS;
        Algorithm _algorithm;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            ptBKhongTrongSo.Visible = false;
            ptbCoTrongSO.Visible = false;
            txtDinh.Enabled = false;
            txtDinhKe.Enabled = false;
            txtSoDinh.Enabled = false;
            txtTrongSo.Enabled = false;
            btnADD.Enabled = false;
            grbChucNang.Visible = false;
        }

        private void btnBFDko_Click(object sender, EventArgs e)
        {
            lblThongBao.Text = "Breath First Search";

            txtDinh.Enabled = true;
            txtDinhKe.Enabled = true;
            txtSoDinh.Enabled = true;
            txtTrongSo.Visible= false;
            lbTrongso.Visible = false;
            ptBKhongTrongSo.Visible = true;
            ptbCoTrongSO.Visible = false;
            btnADD.Enabled = true;
            grbChucNang.Visible = true;
            _algorithm = Algorithm.BreathFirstSearch;
        }

        private void btnBFDco_Click(object sender, EventArgs e)
        {
            lblThongBao.Text = "Best First Search";
            txtDinh.Enabled = true;
            txtDinhKe.Enabled = true;
            txtSoDinh.Enabled = true;
            txtTrongSo.Visible = true;
            txtTrongSo.Enabled = true;
            lbTrongso.Visible = true;
            ptBKhongTrongSo.Visible = false;
            ptbCoTrongSO.Visible = true;
            btnADD.Enabled = true;
            grbChucNang.Visible = true;
            _algorithm = Algorithm.BestFirstSearch;
        }

        private void btnImport_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog openFileDialog = new OpenFileDialog())
            {
                openFileDialog.Filter = "TXT files (*.txt)|*.txt"; // Adjust filter for desired file type
                openFileDialog.ShowDialog();

                if (openFileDialog.FileName != "")
                {
                    using (StreamReader reader = new StreamReader(openFileDialog.FileName))
                    {
                        string fileContent = reader.ReadToEnd();
                        textBox1.Text = fileContent; // Display the content in a TextBox named "textBox1"

                        string[] strings = fileContent.Split(new string[] {"\n"}, StringSplitOptions.None);

                        if (_algorithm == Algorithm.BreathFirstSearch)
                        {
                            _breathFS = new BreathFirstSearch(strings);

                        }
                        else if (_algorithm == Algorithm.BestFirstSearch)
                        {
                            _bestFS = new BestFirstSearch(strings);
                        }

                    }
                }
            }



        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void ptbCoTrongSO_Click(object sender, EventArgs e)
        {

        }

        private void grbLoai_Enter(object sender, EventArgs e)
        {

        }

        private void btnTim_Click(object sender, EventArgs e)
        {
            string filePath = "../../../Exportfile.txt"; // Replace with desired path and filename

            if (_algorithm == Algorithm.BreathFirstSearch)
            {
                if (_breathFS.Solve() == true)
                {
                    MessageBox.Show("Đã tìm được đường đi, kết quả được lưu trong file Exportfile.txt");
                }
                else
                {
                    MessageBox.Show("Không tìm được đường đi");
                }


                using (StreamWriter writer = new StreamWriter(filePath))
                {
                    writer.WriteLine(_breathFS.stringToExport); // Write the data to the file
                    _breathFS.stringToExport = "";
                }
            }
            else if (_algorithm == Algorithm.BestFirstSearch)
            {
                if (_bestFS.Solve() == true)
                {
                    MessageBox.Show("Đã tìm được đường đi, kết quả được lưu trong file Exportfile.txt");
                }
                else
                {
                    MessageBox.Show("Không tìm được đường đi");
                }

                using (StreamWriter writer = new StreamWriter(filePath))
                {
                    writer.WriteLine(_bestFS.stringToExport); // Write the data to the file
                    _bestFS.stringToExport = "";
                }
            }


            


            
            

            
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnVe_Click(object sender, EventArgs e)
        {

        }

		private void btnHuongDan_Click(object sender, EventArgs e)
		{
            HuongDan huongDan = new HuongDan();
            huongDan.Show();
		}

    
    }
}
