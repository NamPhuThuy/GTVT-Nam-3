using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BFS
{
	public partial class HuongDan : Form
	{
		public HuongDan()
		{
			InitializeComponent();
		}

		private void HuongDan_Load(object sender, EventArgs e)
		{
			InputBestFS.Visible = false;
			InputBreathFS.Visible = false;
		}
		private void btnBestFS_Click(object sender, EventArgs e)
		{
			InputBestFS.Visible = true;
			InputBreathFS.Visible = false;
		}

		private void btnBreathFS_Click(object sender, EventArgs e)
		{
			InputBestFS.Visible = false;
			InputBreathFS.Visible = true;
		}

		private void button3_Click(object sender, EventArgs e)
		{
			if(MessageBox.Show("Bạn có muốn thoát không?","",MessageBoxButtons.YesNo)== DialogResult.Yes)
			{
				this.Close();
			}
		}


		private void button1_Click(object sender, EventArgs e)
		{

		}

		private void button2_Click(object sender, EventArgs e)
		{

		}

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }
    }
}
